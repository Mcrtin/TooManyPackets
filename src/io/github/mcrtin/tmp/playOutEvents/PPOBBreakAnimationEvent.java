package io.github.mcrtin.tmp.playOutEvents;

import io.github.mcrtin.tmp.playOutPackets.PPOBBreakAnimation;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;
@Getter
@Setter
public class PPOBBreakAnimationEvent extends PacketPlayOutBlockEvent {
    private int entityId;

    @Nullable
    private Entity entity;
    private int stage;

    public PPOBBreakAnimationEvent(Player injectedPlayer, Location blockLocation, int entityId, @Nullable Entity entity, int stage) {
        super(injectedPlayer, blockLocation);
        this.entityId = entityId;
        this.entity = entity;
        this.stage = stage;
    }
    public PPOBBreakAnimationEvent(Player injectedPlayer, PPOBBreakAnimation packet) {
        super(injectedPlayer, packet.getBlockLocation(injectedPlayer.getWorld()));
        entityId = packet.getEntityId();
        entity = packet.getEntity(injectedPlayer.getWorld());
    }
}
