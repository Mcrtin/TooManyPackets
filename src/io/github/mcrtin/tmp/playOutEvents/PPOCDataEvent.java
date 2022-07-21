package io.github.mcrtin.tmp.playOutEvents;

import io.github.mcrtin.tmp.playOutPackets.PPOCData;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;

import java.util.List;
@Getter
@Setter
public class PPOCDataEvent extends PacketPlayOutChunkEvent {

    private int c;//TODO
    private Object heightmaps;
    private int[] biomes;
    private byte[] data;
    private List<Object> blockEntities;
    private boolean h;//TODO

    public PPOCDataEvent(Player injectedPlayer, int chunkX, int chunkZ, int c, Object heightmaps, int[] biomes, byte[] data, List<Object> blockEntities, boolean h) {
        super(injectedPlayer, chunkX, chunkZ);
        this.c = c;
        this.heightmaps = heightmaps;
        this.biomes = biomes;
        this.data = data;
        this.blockEntities = blockEntities;
        this.h = h;
    }
    public PPOCDataEvent(Player injectedPlayer, PPOCData packet) {
        super(injectedPlayer, packet);
        c = packet.getC();
        heightmaps = packet.getHeightmaps();
        biomes = packet.getBiomes();
        data = packet.getData();
        blockEntities = packet.getBlockEntities();
        h = packet.getH();
    }
}
