package io.github.mcrtin.tmp.playOutPackets;

import io.github.mcrtin.tmp.TooManyPackets;
import org.bukkit.World;
import org.bukkit.entity.Entity;

import javax.annotation.Nullable;

public interface PacketPlayOutEntity extends PacketPlayOut {
    int getEntityId();
    @Nullable
    default Entity getEntity(World world) {
        return TooManyPackets.getEntityById(getEntityId(), world);
    }
}
