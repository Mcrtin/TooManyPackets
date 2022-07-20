package io.github.mcrtin.tmp.playOutPackets;

import org.bukkit.World;
import org.bukkit.entity.Entity;

import javax.annotation.Nullable;

public interface PPOBBreakAnimation extends PacketPlayOutBlock {
    int getEntityId();
    int getStage();
    @Nullable
    Entity getEntity(World world);
}
