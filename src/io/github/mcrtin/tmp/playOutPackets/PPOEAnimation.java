package io.github.mcrtin.tmp.playOutPackets;

import io.github.mcrtin.tmp.player.PlayerAnimation;

public interface PPOEAnimation {
	public void setEntityId(int entityId);

	public int getEntityId();

	public void setAnimation(PlayerAnimation playerAnimation);

	public PlayerAnimation getAnimation();

}
