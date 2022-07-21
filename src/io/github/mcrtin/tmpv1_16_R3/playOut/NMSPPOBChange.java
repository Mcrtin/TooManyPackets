package io.github.mcrtin.tmpv1_16_R3.playOut;

import io.github.mcrtin.tmp.playOutEvents.PPOBChangeEvent;
import io.github.mcrtin.tmp.playOutEvents.PacketPlayOutEvent;
import io.github.mcrtin.tmp.playOutPackets.PPOBChange;
import io.github.mcrtin.tmp.reflections.Field;
import io.github.mcrtin.tmpv1_16_R3.PacketUtils;
import lombok.AllArgsConstructor;
import net.minecraft.server.v1_16_R3.BlockPosition;
import net.minecraft.server.v1_16_R3.IBlockData;
import net.minecraft.server.v1_16_R3.PacketPlayOutBlockChange;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
@AllArgsConstructor
public class NMSPPOBChange implements PPOBChange {
    private final PacketPlayOutBlockChange packet;

    @Override
    public Material getMaterial() {
        return PacketUtils.toMaterial(Field.get(packet, "b", IBlockData.class).getBlock().getItem());
    }

    @Override
    public void send(Player player) {
        PacketUtils.sendPacket(player, packet);
    }

    @Override
    public PacketPlayOutEvent buildEvent(Player player) {
        return new PPOBChangeEvent(player, this);
    }

    @Override
    public Location getBlockLocation(World world) {
        return PacketUtils.toLocation(Field.get(packet, "a", BlockPosition.class), world);
    }
}
