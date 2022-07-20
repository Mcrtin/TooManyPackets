package io.github.mcrtin.tmpv1_16_R3.playOut;

import io.github.mcrtin.tmp.playOutEvents.PPOBActionEvent;
import io.github.mcrtin.tmp.playOutEvents.PacketPlayOutEvent;
import io.github.mcrtin.tmp.playOutPackets.PPOBAction;
import io.github.mcrtin.tmp.reflections.Field;
import io.github.mcrtin.tmpv1_16_R3.PacketUtils;
import lombok.AllArgsConstructor;
import net.minecraft.server.v1_16_R3.Block;
import net.minecraft.server.v1_16_R3.BlockPosition;
import net.minecraft.server.v1_16_R3.PacketPlayOutBlockAction;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
@AllArgsConstructor
public class NMSPPOBAction implements PPOBAction {
    private final PacketPlayOutBlockAction packet;
    @Override
    public int getActionId() {
        return Field.get(packet, "b", int.class);
    }

    @Override
    public int getActionParam() {
        return Field.get(packet, "c", int.class);
    }

    @Override
    public Material getMaterial() {
        return PacketUtils.toMaterial(Field.get(packet, "d", Block.class).getItem());
    }

    @Override
    public void send(Player player) {
        PacketUtils.sendPacket(player, packet);
    }

    @Override
    public PacketPlayOutEvent buildEvent(Player player) {
        return new PPOBActionEvent(player, this);
    }

    @Override
    public Location getBlockLocation(World world) {
        return PacketUtils.toLocation(Field.get(packet, "a", BlockPosition.class), world);
    }
}
