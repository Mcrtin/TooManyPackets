package io.github.mcrtin.tmp.playOutEvents;

import org.bukkit.entity.Player;

import io.github.mcrtin.tmp.PacketEvent;
import io.github.mcrtin.tmp.PacketType;

public abstract class PacketPlayOutEvent extends PacketEvent {

	public PacketPlayOutEvent(Player injectedPlayer) {
		super(injectedPlayer, PacketType.PLAY_OUT);
	}
}