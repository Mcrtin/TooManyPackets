package io.github.mcrtin.tmp.playOutEvents;

import io.github.mcrtin.tmp.bossBar.BossBarAction;
import io.github.mcrtin.tmp.playOutPackets.PPOBossBar;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.entity.Player;

import java.util.UUID;
@Getter
@Setter
public class PPOBossBarEvent extends PacketPlayOutEvent {
    /**
     * Unique ID for this bar.
     */
    private UUID barId;
    private BossBarAction action;

    protected PPOBossBarEvent(Player injectedPlayer, UUID barId, BossBarAction action) {
        super(injectedPlayer);
        this.barId = barId;
        this.action = action;
    }

    public static PPOBossBarEvent of(Player injectedPlayer, PPOBossBar packet) {
       return switch (packet.getAction()) {
           case ADD -> new PPOBossBarAddEvent(injectedPlayer, packet);
           case REMOVE -> new PPOBossBarRemoveEvent(injectedPlayer, packet);
           case UPDATE_HEALTH -> new PPOBossBarUpdateHealthEvent(injectedPlayer, packet);
           case UPDATE_TITLE -> new PPOBossBarUpdateTitleEvent(injectedPlayer, packet);
           case UPDATE_STYLE -> new PPOBossBarUpdateStyleEvent(injectedPlayer, packet);
           case UPDATE_PROPERTIES -> new PPOBossBarUpdatePropertiesEvent(injectedPlayer, packet);
       };
    }
    @Getter
    @Setter
    public static class PPOBossBarAddEvent extends PPOBossBarEvent {
        private String title;
        private float health;
        private BarColor color;
        private BarStyle style;
        private boolean skyDarken;
        private boolean playEndMusic;
        private boolean createFog;

        public PPOBossBarAddEvent(Player injectedPlayer, UUID barId, String title, float health, BarColor color, BarStyle style, boolean skyDarken, boolean playEndMusic, boolean createFog) {
            super(injectedPlayer, barId, BossBarAction.ADD);
            this.title = title;
            this.health = health;
            this.color = color;
            this.style = style;
            this.skyDarken = skyDarken;
            this.playEndMusic = playEndMusic;
            this.createFog = createFog;
        }

        public PPOBossBarAddEvent(Player injectedPlayer, PPOBossBar packet) {
            super(injectedPlayer, packet.getBarId(), BossBarAction.ADD);
            title = packet.getTitle();
            health = packet.getHealth();
            color = packet.getColor();
            style = packet.getStyle();
            skyDarken = packet.isSkyDarken();
            playEndMusic = packet.isPlayEndMusic();
            createFog = packet.isCreateFog();
        }
    }

    public static class PPOBossBarRemoveEvent extends PPOBossBarEvent {

        public PPOBossBarRemoveEvent(Player injectedPlayer, UUID barId) {
            super(injectedPlayer, barId, BossBarAction.REMOVE);
        }

        public PPOBossBarRemoveEvent(Player injectedPlayer, PPOBossBar packet) {
            super(injectedPlayer, packet.getBarId(), BossBarAction.REMOVE);
        }
    }
    @Getter
    @Setter
    public static class PPOBossBarUpdateHealthEvent extends PPOBossBarEvent {
        private float health;

        public PPOBossBarUpdateHealthEvent(Player injectedPlayer, UUID barId, float health) {
            super(injectedPlayer, barId, BossBarAction.UPDATE_HEALTH);
            this.health = health;
        }

        public PPOBossBarUpdateHealthEvent(Player injectedPlayer, PPOBossBar packet) {
            super(injectedPlayer, packet.getBarId(), BossBarAction.UPDATE_HEALTH);
            health = packet.getHealth();
        }
    }

    @Getter
    @Setter
    public static class PPOBossBarUpdateTitleEvent extends PPOBossBarEvent {
        private String title;

        public PPOBossBarUpdateTitleEvent(Player injectedPlayer, UUID barId, String title) {
            super(injectedPlayer, barId, BossBarAction.UPDATE_TITLE);
            this.title = title;
        }

        public PPOBossBarUpdateTitleEvent(Player injectedPlayer, PPOBossBar packet) {
            super(injectedPlayer, packet.getBarId(), BossBarAction.UPDATE_TITLE);
            title = packet.getTitle();
        }
    }

    @Getter
    @Setter
    public static class PPOBossBarUpdateStyleEvent extends PPOBossBarEvent {
        private BarColor color;
        private BarStyle style;
        public PPOBossBarUpdateStyleEvent(Player injectedPlayer, UUID barId, BarStyle style, BarColor color) {
            super(injectedPlayer, barId, BossBarAction.UPDATE_STYLE);
            this.color = color;
            this.style = style;
        }

        public PPOBossBarUpdateStyleEvent(Player injectedPlayer, PPOBossBar packet) {
            super(injectedPlayer, packet.getBarId(), BossBarAction.UPDATE_STYLE);
            color = packet.getColor();
            style = packet.getStyle();
        }
    }

    @Getter
    @Setter
    public static class PPOBossBarUpdatePropertiesEvent extends PPOBossBarEvent {
        private boolean skyDarken;
        private boolean playEndMusic;
        private boolean createFog;

        public PPOBossBarUpdatePropertiesEvent(Player injectedPlayer, UUID barId, boolean skyDarken, boolean playEndMusic, boolean createFog) {
            super(injectedPlayer, barId, BossBarAction.UPDATE_PROPERTIES);
            this.skyDarken = skyDarken;
            this.playEndMusic = playEndMusic;
            this.createFog = createFog;
        }

        public PPOBossBarUpdatePropertiesEvent(Player injectedPlayer, PPOBossBar packet) {
            super(injectedPlayer, packet.getBarId(), BossBarAction.UPDATE_TITLE);
            skyDarken = packet.isSkyDarken();
            playEndMusic = packet.isPlayEndMusic();
            createFog = packet.isCreateFog();
        }
    }
}
