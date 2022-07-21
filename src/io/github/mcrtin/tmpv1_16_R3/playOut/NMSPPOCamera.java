package io.github.mcrtin.tmpv1_16_R3.playOut;

import io.github.mcrtin.tmp.playOutEvents.PPOCameraEvent;
import io.github.mcrtin.tmp.playOutEvents.PacketPlayOutEvent;
import io.github.mcrtin.tmp.playOutPackets.PPOCamera;
import io.github.mcrtin.tmp.reflections.Field;
import io.github.mcrtin.tmpv1_16_R3.PacketUtils;
import lombok.AllArgsConstructor;
import net.minecraft.server.v1_16_R3.PacketPlayOutCamera;
import org.bukkit.entity.Player;

@AllArgsConstructor
public class NMSPPOCamera implements PPOCamera {
    private final PacketPlayOutCamera packet;

    @Override
    public void send(Player player) {
        PacketUtils.sendPacket(player, packet);
    }

    @Override
    public PacketPlayOutEvent buildEvent(Player player) {
        return new PPOCameraEvent(player, this);
    }

    @Override
    public int getEntityId() {
        return Field.get(packet, "a", int.class);
    }
}
