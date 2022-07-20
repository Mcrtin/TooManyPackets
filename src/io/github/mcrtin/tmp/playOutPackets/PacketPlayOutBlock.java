package io.github.mcrtin.tmp.playOutPackets;

import org.bukkit.Location;
import org.bukkit.World;

public interface PacketPlayOutBlock extends PacketPlayOut {
    Location getBlockLocation(World world);
}
