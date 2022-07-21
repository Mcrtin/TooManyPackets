package io.github.mcrtin.tmp.playOutEvents;

import io.github.mcrtin.tmp.playOutPackets.PPOCamera;
import org.bukkit.entity.Player;

public class PPOCameraEvent extends PacketPlayOutEntityEvent {

    public PPOCameraEvent(Player injectedPlayer, int entityId) {
        super(injectedPlayer, entityId);
    }

    public PPOCameraEvent(Player injectedPlayer, PPOCamera packet) {
        super(injectedPlayer, packet.getEntityId());
    }
}
