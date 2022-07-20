package io.github.mcrtin.tmpv1_16_R3.playOut;

import io.github.mcrtin.tmp.playOutEvents.PPOEAnimationEvent;
import io.github.mcrtin.tmp.playOutPackets.PPOEAnimation;
import io.github.mcrtin.tmp.player.PlayerAnimation;
import io.github.mcrtin.tmp.reflections.Field;
import io.github.mcrtin.tmpv1_16_R3.PacketUtils;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import net.minecraft.server.v1_16_R3.PacketPlayOutAnimation;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

@AllArgsConstructor
public class NMSPPOEAnimation implements PPOEAnimation {
	@NonNull
	private final PacketPlayOutAnimation packet;

	@Override
	public PlayerAnimation getAnimation() {
		return PlayerAnimation.getByID(Field.get(packet, "b", int.class));
	}

	@Override
	public void send(Player player) {
		PacketUtils.sendPacket(player, packet);
	}

	@Override
	public PPOEAnimationEvent buildEvent(Player player) {
		return new PPOEAnimationEvent(player, this);
	}

	@Override
	public int getEntityId() {
		return Field.get(packet, "a", int.class);
	}

}
