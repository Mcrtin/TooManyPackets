package io.github.mcrtin.tmpv1_16_R3.playOut;

import io.github.mcrtin.tmp.playOutEvents.PPOECollectEvent;
import io.github.mcrtin.tmp.playOutEvents.PacketPlayOutEvent;
import io.github.mcrtin.tmp.playOutPackets.PPOECollect;
import io.github.mcrtin.tmp.reflections.Field;
import io.github.mcrtin.tmpv1_16_R3.PacketUtils;
import lombok.AllArgsConstructor;
import net.minecraft.server.v1_16_R3.PacketPlayOutCollect;
import org.bukkit.entity.Player;

@AllArgsConstructor
public class NMSPPOECollect implements PPOECollect {
    private final PacketPlayOutCollect packet;

    @Override
    public int getEntityId() {
        return Field.get(packet, "a", int.class);
    }

    @Override
    public int getCollectorEntityId() {
        return Field.get(packet, "b", int.class);
    }

    @Override
    public int getCount() {
        return Field.get(packet, "c", int.class);
    }

    @Override
    public void send(Player player) {
        PacketUtils.sendPacket(player, packet);
    }

    @Override
    public PacketPlayOutEvent buildEvent(Player player) {
        return new PPOECollectEvent(player, this);
    }


}
