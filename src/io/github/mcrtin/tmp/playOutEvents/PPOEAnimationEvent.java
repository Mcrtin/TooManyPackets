package io.github.mcrtin.tmp.playOutEvents;

import io.github.mcrtin.tmp.playOutPackets.PPOEAnimation;
import io.github.mcrtin.tmp.player.PlayerAnimation;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.bukkit.entity.Player;

@Getter
@Setter
public class PPOEAnimationEvent extends PacketPlayOutEntityEvent {
	@NonNull
	private PlayerAnimation animation;

	public PPOEAnimationEvent(Player injectedPlayer, @NonNull PlayerAnimation animation, int entityId) {
		super(injectedPlayer, entityId);
		this.animation = animation;
	}
	public PPOEAnimationEvent(Player injectedPlayer, PPOEAnimation packet) {
		super(injectedPlayer, packet.getEntityId());
		animation = packet.getAnimation();
	}
}