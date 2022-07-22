package io.github.mcrtin.tmp.playOutPackets;

import io.github.mcrtin.tmp.player.CombatType;

import javax.annotation.Nullable;

public interface PPOCombat extends PacketPlayOut {

    CombatType getType();

    int getDuration();

    int getOpponentId();

    int getPlayerId();

    @Nullable
    String getDeathMessage();

}
