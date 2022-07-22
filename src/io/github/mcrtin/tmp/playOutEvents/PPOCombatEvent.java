package io.github.mcrtin.tmp.playOutEvents;

import io.github.mcrtin.tmp.TooManyPackets;
import io.github.mcrtin.tmp.playOutPackets.PPOBossBar;
import io.github.mcrtin.tmp.playOutPackets.PPOCombat;
import io.github.mcrtin.tmp.player.CombatType;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;

@Getter
@Setter
public class PPOCombatEvent extends PacketPlayOutEvent {
    private CombatType type;

    public PPOCombatEvent(Player injectedPlayer, CombatType type) {
        super(injectedPlayer);
        this.type = type;
    }

    public static PPOCombatEvent of(Player injectedPlayer, PPOCombat packet) {
        return switch (packet.getType()) {
            case ENTER_COMBAT -> new PPOCombatEnterEvent(injectedPlayer, packet);
            case END_COMBAT -> new PPOCombatEndEvent(injectedPlayer, packet);
            case ENTITY_DIED -> new PPOCombatDeathEvent(injectedPlayer, packet);
        };
    }

    public static class PPOCombatEnterEvent extends PPOCombatEvent {
        public PPOCombatEnterEvent(Player injectedPlayer) {
            super(injectedPlayer, CombatType.ENTER_COMBAT);
        }

        public PPOCombatEnterEvent(Player injectedPlayer, PPOCombat packet) {
            super(injectedPlayer, CombatType.ENTER_COMBAT);
        }
    }

    @Getter
    @Setter
    public static class PPOCombatEndEvent extends PPOCombatEvent {
        private int duration;
        private int opponentId;

        public PPOCombatEndEvent(Player injectedPlayer, int duration, int opponentId) {
            super(injectedPlayer, CombatType.END_COMBAT);
            this.duration = duration;
            this.opponentId = opponentId;
        }

        public PPOCombatEndEvent(Player injectedPlayer, PPOCombat packet) {
            super(injectedPlayer, CombatType.END_COMBAT);
            duration = packet.getDuration();
            opponentId = packet.getOpponentId();
        }

        @Nullable
        public Entity getOpponent() {
            return TooManyPackets.getEntityById(opponentId, getPlayer().getWorld());
        }
    }

    @Getter
    @Setter
    public static class PPOCombatDeathEvent extends PPOCombatEvent {
        private int playerId;
        private int opponentId;
        private String deathMessage;

        public PPOCombatDeathEvent(Player injectedPlayer, int playerId, int opponentId, String deathMessage) {
            super(injectedPlayer, CombatType.ENTITY_DIED);
            this.playerId = playerId;
            this.opponentId = opponentId;
            this.deathMessage = deathMessage;
        }

        public PPOCombatDeathEvent(Player injectedPlayer, PPOCombat packet) {
            super(injectedPlayer, CombatType.ENTITY_DIED);
            playerId = packet.getPlayerId();
            opponentId = packet.getOpponentId();
            deathMessage = packet.getDeathMessage();
        }

        @Nullable
        public Entity getOpponent() {
            return TooManyPackets.getEntityById(opponentId, getPlayer().getWorld());
        }
    }
}
