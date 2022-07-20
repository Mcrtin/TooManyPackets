package io.github.mcrtin.tmp.playOutPackets;

import org.bukkit.entity.Player;

import io.github.mcrtin.tmp.playOutEvents.PacketPlayOutEvent;

public interface PacketPlayOut {
	void send(Player player);
	PacketPlayOutEvent buildEvent(Player player);
}
