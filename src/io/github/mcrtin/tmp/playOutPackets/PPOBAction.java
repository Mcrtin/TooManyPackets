package io.github.mcrtin.tmp.playOutPackets;

import org.bukkit.Material;

public interface PPOBAction extends PacketPlayOutBlock {
    int getActionId();

    int getActionParam();

    Material getMaterial();
}
