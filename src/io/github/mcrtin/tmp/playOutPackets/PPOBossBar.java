package io.github.mcrtin.tmp.playOutPackets;

import io.github.mcrtin.tmp.bossBar.BossBarAction;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;

import javax.annotation.Nullable;
import java.util.UUID;

public interface PPOBossBar extends PacketPlayOut {
    UUID getBarId();
    BossBarAction getAction();
    @Nullable
    String getTitle();
    float getHealth();
    @Nullable
    BarColor getColor();
    @Nullable
    BarStyle getStyle();
    boolean isSkyDarken();
    boolean isPlayEndMusic();
    boolean isCreateFog();
}
