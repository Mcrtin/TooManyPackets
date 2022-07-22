package io.github.mcrtin.tmp.playOutPackets;

import io.netty.buffer.ByteBuf;
import org.bukkit.NamespacedKey;

public interface PPOCustomPayload extends PacketPlayOut {
    NamespacedKey getChannel();

    ByteBuf getData();
}
