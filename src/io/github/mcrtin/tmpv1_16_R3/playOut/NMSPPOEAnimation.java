package io.github.mcrtin.tmpv1_16_R3.playOut;

import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import io.github.mcrtin.tmp.playOutEvents.PPOEAnimationEvent;
import io.github.mcrtin.tmp.playOutPackets.PPOEAnimation;
import io.github.mcrtin.tmp.player.PlayerAnimation;
import io.github.mcrtin.tmp.reflections.Field;
import lombok.NonNull;
import net.minecraft.server.v1_16_R3.PacketPlayOutAnimation;

public class NMSPPOEAnimation implements PPOEAnimation, NMSPacketPlayOut {
	@NonNull
	private PacketPlayOutAnimation packet;

	public NMSPPOEAnimation(@NonNull PacketPlayOutAnimation packet) {
		this.packet = packet;
	}

	@Override
	public void setAnimation(PlayerAnimation playerAnimation) {
		Field.set(packet, "b", playerAnimation.getId());
	}

	@Override
	public PlayerAnimation getAnimation() {
		return PlayerAnimation.getByID(Field.get(packet, "b", int.class));
	}

	@Override
	public void send(Player player) {
		((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
	}

	@Override
	public PPOEAnimationEvent buildEvent(Player player) {
		return new PPOEAnimationEvent(player, getAnimation(), getEntityId());
	}

	@Override
	public void setEntityId(int entityId) {
		Field.set(packet, "a", entityId);
	}

	@Override
	public int getEntityId() {
		return Field.get(packet, "a", int.class);
	}

}
