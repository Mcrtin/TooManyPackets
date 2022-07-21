package io.github.mcrtin.tmpv1_16_R3.playOut;

import io.github.mcrtin.tmp.block.BlockAction;
import io.github.mcrtin.tmp.playOutEvents.PPOBDataEvent;
import io.github.mcrtin.tmp.playOutEvents.PacketPlayOutEvent;
import io.github.mcrtin.tmp.playOutPackets.PPOBData;
import io.github.mcrtin.tmp.reflections.Field;
import io.github.mcrtin.tmpv1_16_R3.PacketUtils;
import lombok.AllArgsConstructor;
import net.minecraft.server.v1_16_R3.BlockPosition;
import net.minecraft.server.v1_16_R3.NBTTagCompound;
import net.minecraft.server.v1_16_R3.PacketPlayOutTileEntityData;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
@AllArgsConstructor
public class NMSPPOBData implements PPOBData {
    private final PacketPlayOutTileEntityData packet;

    @Override
    public BlockAction getAction() {
        return BlockAction.getById(Field.get(packet, "b", int.class));
    }

    @Override
    public Object getNBTTag() {
        return Field.get(packet, "c", NBTTagCompound.class);
    }

    @Override
    public void send(Player player) {
        PacketUtils.sendPacket(player, packet);
    }

    @Override
    public PacketPlayOutEvent buildEvent(Player player) {
        return new PPOBDataEvent(player, this);
    }

    @Override
    public Location getBlockLocation(World world) {
        return PacketUtils.toLocation(Field.get(packet, "a", BlockPosition.class), world);
    }
}
