package io.github.mcrtin.tmp;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import io.github.mcrtin.tmp.playOutEvents.PacketPlayOutEvent;
import io.github.mcrtin.tmpv1_16_R3.playOut.NMSPPOAdvancements;
import io.github.mcrtin.tmpv1_16_R3.playOut.NMSPacketPlayOut;
import io.netty.channel.Channel;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import net.minecraft.server.v1_16_R3.Packet;
import net.minecraft.server.v1_16_R3.PacketPlayOutAdvancements;

public class Injections implements Listener {

	private void injectPlayer(Player player) {
		final ChannelDuplexHandler channelDuplexHandler = new ChannelDuplexHandler() {
			@Override
			public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//				if (!Injections.this.readIn(player, ctx, msg, this))
				super.channelRead(ctx, msg);
			}

			@Override
			public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
				if (!Injections.this.readOut(player, msg))
					super.write(ctx, msg, promise);
			}
		};
		((CraftPlayer) player).getHandle().playerConnection.networkManager.channel.pipeline()
				.addBefore("packet_handler", player.getName(), channelDuplexHandler);
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		injectPlayer(e.getPlayer());
	}

	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent e) {
		removePlayer(e.getPlayer());
	}

	private void removePlayer(Player player) {
		final Channel channel = ((CraftPlayer) player).getHandle().playerConnection.networkManager.channel;
		channel.eventLoop().submit(() -> channel.pipeline().remove(player.getName()));
	}

	private boolean readOut(Player player, Object msg) {
		Class<? extends NMSPacketPlayOut> clazz = mapOut.get(msg.getClass());
		if (clazz == null) {
			System.err.println("[OUT] unregistered packet: " + msg.getClass().getSimpleName());
			return false;
		}
		try {
			NMSPacketPlayOut packet = clazz.getConstructor(Player.class, msg.getClass()).newInstance(player, msg);
			PacketPlayOutEvent event = packet.buildEvent();
			Bukkit.getPluginManager().callEvent(event);
			return event.isCancelled();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			System.err.println("[ERROR] packet out: " + msg.getClass().getSimpleName());
			e.printStackTrace();
		}
		return false;

	}

	private static final HashMap<Class<? extends Packet<?>>, Class<? extends NMSPacketPlayOut>> mapOut = new HashMap<>();
	static {
		mapOut.put(PacketPlayOutAdvancements.class, NMSPPOAdvancements.class);
	}
}