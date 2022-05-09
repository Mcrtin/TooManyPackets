package io.github.mcrtin.tmp.playOutEvents;

import org.bukkit.entity.Player;

import io.github.mcrtin.tmp.player.PlayerAnimation;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class PPOEAnimationEvent extends PacketPlayOutEntityEvent {
	@NonNull
	private PlayerAnimation animation;

	public PPOEAnimationEvent(Player injectedPlayer, PlayerAnimation animation, int entityId) {
		super(injectedPlayer, entityId);
		this.animation = animation;
	}

}