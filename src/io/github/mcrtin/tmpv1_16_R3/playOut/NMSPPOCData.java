package io.github.mcrtin.tmpv1_16_R3.playOut;

import io.github.mcrtin.tmp.playOutEvents.PPOCDataEvent;
import io.github.mcrtin.tmp.playOutEvents.PacketPlayOutEvent;
import io.github.mcrtin.tmp.playOutPackets.PPOCData;
import io.github.mcrtin.tmp.reflections.Field;
import io.github.mcrtin.tmpv1_16_R3.PacketUtils;
import lombok.AllArgsConstructor;
import net.minecraft.server.v1_16_R3.NBTTagCompound;
import net.minecraft.server.v1_16_R3.PacketPlayOutMapChunk;
import org.bukkit.entity.Player;

import java.util.List;

@AllArgsConstructor
public class NMSPPOCData implements PPOCData {
    private final PacketPlayOutMapChunk packet;

    @Override
    public int getChunkX() {
        return Field.get(packet, "a", int.class);
    }

    @Override
    public int getChunkZ() {
        return Field.get(packet, "b", int.class);
    }

    @Override
    public int getC() {
        return Field.get(packet, "c", int.class);
    }

    @Override
    public Object getHeightmaps() {
        return Field.get(packet, "d", NBTTagCompound.class);
    }

    @Override
    public int[] getBiomes() {
        return Field.get(packet, "e", int[].class);
    }

    @Override
    public byte[] getData() {
        return Field.get(packet, "f", byte[].class);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Object> getBlockEntities() {
        return Field.get(packet, "g", List.class);
    }

    @Override
    public boolean getH() {
        return Field.get(packet, "h", boolean.class);
    }

    @Override
    public void send(Player player) {
        PacketUtils.sendPacket(player, packet);
    }

    @Override
    public PacketPlayOutEvent buildEvent(Player player) {
        return new PPOCDataEvent(player, this);
    }
}
