package io.github.mcrtin.tmpv1_16_R3.playOut;

import io.github.mcrtin.tmp.playOutEvents.PPOCombatEvent;
import io.github.mcrtin.tmp.playOutEvents.PacketPlayOutEvent;
import io.github.mcrtin.tmp.playOutPackets.PPOCombat;
import io.github.mcrtin.tmp.player.CombatType;
import io.github.mcrtin.tmp.reflections.Field;
import io.github.mcrtin.tmpv1_16_R3.PacketUtils;
import lombok.AllArgsConstructor;
import net.minecraft.server.v1_16_R3.IChatBaseComponent;
import net.minecraft.server.v1_16_R3.PacketPlayOutCombatEvent;
import org.bukkit.craftbukkit.v1_16_R3.util.CraftChatMessage;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;

@AllArgsConstructor
public class NMSPPOCombat implements PPOCombat {
    private final PacketPlayOutCombatEvent packet;

    @Override
    public CombatType getType() {
        return CombatType.getById(Field.get(packet, "a", PacketPlayOutCombatEvent.EnumCombatEventType.class).ordinal());
    }

    @Override
    public int getPlayerId() {
        return Field.get(packet, "b", int.class);
    }

    @Override
    public int getOpponentId() {
        return Field.get(packet, "c", int.class);
    }

    @Override
    public int getDuration() {
        return Field.get(packet, "d", int.class);
    }

    @Override
    @Nullable
    public String getDeathMessage() {
        return CraftChatMessage.fromComponent(Field.get(packet, "e", IChatBaseComponent.class));
    }

    @Override
    public void send(Player player) {
        PacketUtils.sendPacket(player, packet);
    }

    @Override
    public PacketPlayOutEvent buildEvent(Player player) {
        return PPOCombatEvent.of(player, this);
    }
}
