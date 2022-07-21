package io.github.mcrtin.tmpv1_16_R3.playOut;

import io.github.mcrtin.tmp.bossBar.BossBarAction;
import io.github.mcrtin.tmp.playOutEvents.PacketPlayOutEvent;
import io.github.mcrtin.tmp.playOutPackets.PPOBossBar;
import io.github.mcrtin.tmp.reflections.Field;
import lombok.AllArgsConstructor;
import net.minecraft.server.v1_16_R3.BossBattle;
import net.minecraft.server.v1_16_R3.IChatBaseComponent;
import net.minecraft.server.v1_16_R3.PacketPlayOutBoss;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.craftbukkit.v1_16_R3.util.CraftChatMessage;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;
import java.util.UUID;

@AllArgsConstructor
public class NMSPPOBossBar implements PPOBossBar {
    private final PacketPlayOutBoss packet;

    @Override
    public UUID getBarId() {
        return Field.get(packet, "a", UUID.class);
    }

    @Override
    public BossBarAction getAction() {
        return BossBarAction.getById(Field.get(packet, "b", PacketPlayOutBoss.Action.class).ordinal());
    }

    @Nullable
    @Override
    public String getTitle() {
        return CraftChatMessage.fromComponent(Field.get(packet, "c", IChatBaseComponent.class));
    }

    @Override
    public float getHealth() {
        return Field.get(packet, "d", float.class);
    }

    @Nullable
    @Override
    public BarColor getColor() {
        return BarColor.valueOf(Field.get(packet, "e", BossBattle.BarColor.class).name());
    }

    @Nullable
    @Override
    public BarStyle getStyle() {
        return BarStyle.valueOf(Field.get(packet, "f", BossBattle.BarStyle.class).name());
    }

    @Override
    public boolean isSkyDarken() {
        return Field.get(packet, "g", boolean.class);
    }

    @Override
    public boolean isPlayEndMusic() {
        return Field.get(packet, "h", boolean.class);
    }

    @Override
    public boolean isCreateFog() {
        return Field.get(packet, "i", boolean.class);
    }

    @Override
    public void send(Player player) {

    }

    @Override
    public PacketPlayOutEvent buildEvent(Player player) {
        return null;
    }
}
