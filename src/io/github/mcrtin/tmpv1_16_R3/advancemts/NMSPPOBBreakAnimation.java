package io.github.mcrtin.tmpv1_16_R3.advancemts;


import io.github.mcrtin.tmp.playOutEvents.PPOBBreakAnimationEvent;
import io.github.mcrtin.tmp.playOutEvents.PacketPlayOutEvent;
import io.github.mcrtin.tmp.playOutPackets.PPOBBreakAnimation;
import io.github.mcrtin.tmp.reflections.Field;
import io.github.mcrtin.tmpv1_16_R3.PacketUtils;
import lombok.AllArgsConstructor;
import net.minecraft.server.v1_16_R3.BlockPosition;
import net.minecraft.server.v1_16_R3.PacketPlayOutBlockBreakAnimation;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;

@AllArgsConstructor
public class NMSPPOBBreakAnimation implements PPOBBreakAnimation {
    private final PacketPlayOutBlockBreakAnimation packet;
    @Override
    public int getEntityId() {
        return Field.get(packet, "a", int.class);
    }

    @Override
    public int getStage() {
        return Field.get(packet, "c", int.class);
    }

    @Override
    @Nullable
    public Entity getEntity(World world) {
        return PacketUtils.getEntity(world, getEntityId());
    }

    @Override
    public void send(Player player) {
        PacketUtils.sendPacket(player, packet);
    }

    @Override
    public PacketPlayOutEvent buildEvent(Player player) {
        return new PPOBBreakAnimationEvent(player, this);
    }

    @Override
    public Location getBlockLocation(World world) {
        return PacketUtils.toLocation(Field.get(packet, "b", BlockPosition.class), world);
    }

    public PacketPlayOutBlockBreakAnimation getHandle() {
        return packet;
    }
}