package io.github.mcrtin.tmp.playOutEvents;

import io.github.mcrtin.tmp.playOutPackets.PPOBBreakAnimation;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R3.CraftServer;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftEntity;
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
    @Nullable
    public Entity getEntity() {
        return CraftEntity.getEntity((CraftServer) Bukkit.getServer(),((CraftWorld)getPlayer().getWorld()).getHandle().getEntity(entityId));
    }
}
