package io.github.mcrtin.tmp.playOutEvents;

import io.github.mcrtin.tmp.playOutPackets.PacketPlayOutChunk;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;

@Getter
@Setter
public class PacketPlayOutChunkEvent extends PacketPlayOutEvent {

    private int chunkX;
    private int chunkZ;

    public PacketPlayOutChunkEvent(Player injectedPlayer, int chunkX, int chunkZ) {
        super(injectedPlayer);
        this.chunkX = chunkX;
        this.chunkZ = chunkZ;
    }

    public PacketPlayOutChunkEvent(Player injectedPlayer, PacketPlayOutChunk packet) {
        super(injectedPlayer);
        chunkX = packet.getChunkX();
        chunkZ = packet.getChunkZ();
    }
}
