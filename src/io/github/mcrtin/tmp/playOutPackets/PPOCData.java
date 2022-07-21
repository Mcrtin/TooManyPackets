package io.github.mcrtin.tmp.playOutPackets;

import java.util.List;

public interface PPOCData extends PacketPlayOutChunk {
    int getC();
    Object getHeightmaps();
    int[] getBiomes();
    byte[] getData();
    List<Object> getBlockEntities();
    boolean getH();
}
