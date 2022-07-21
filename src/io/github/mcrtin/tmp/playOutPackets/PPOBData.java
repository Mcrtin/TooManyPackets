package io.github.mcrtin.tmp.playOutPackets;

import io.github.mcrtin.tmp.block.BlockAction;

public interface PPOBData extends PacketPlayOutBlock {
    BlockAction getAction();
    Object getNBTTag();
}
