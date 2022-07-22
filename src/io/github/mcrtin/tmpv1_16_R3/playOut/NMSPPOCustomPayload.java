package io.github.mcrtin.tmpv1_16_R3.playOut;

import io.github.mcrtin.tmp.playOutEvents.PPOCustomPayloadEvent;
import io.github.mcrtin.tmp.playOutEvents.PacketPlayOutEvent;
import io.github.mcrtin.tmp.playOutPackets.PPOCustomPayload;
import io.github.mcrtin.tmp.reflections.Field;
import io.github.mcrtin.tmpv1_16_R3.PacketUtils;
import io.netty.buffer.ByteBuf;
import lombok.AllArgsConstructor;
import net.minecraft.server.v1_16_R3.MinecraftKey;
import net.minecraft.server.v1_16_R3.PacketDataSerializer;
import net.minecraft.server.v1_16_R3.PacketPlayOutCustomPayload;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;

@AllArgsConstructor
public class NMSPPOCustomPayload implements PPOCustomPayload {
    private final PacketPlayOutCustomPayload packet;

    @Override
    public NamespacedKey getChannel() {
        return PacketUtils.toNamespacedKey(Field.get(packet, "r", MinecraftKey.class));
    }

    @Override
    public ByteBuf getData() {
        return Field.get(packet, "s", PacketDataSerializer.class);
    }

    @Override
    public void send(Player player) {
        PacketUtils.sendPacket(player, packet);
    }

    @Override
    public PacketPlayOutEvent buildEvent(Player player) {
        return new PPOCustomPayloadEvent(player, this);
    }
}
