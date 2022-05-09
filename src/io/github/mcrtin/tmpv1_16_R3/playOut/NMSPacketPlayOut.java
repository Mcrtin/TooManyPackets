package io.github.mcrtin.tmpv1_16_R3.playOut;

import org.bukkit.entity.Player;

import io.github.mcrtin.tmp.playOutEvents.PacketPlayOutEvent;

public interface NMSPacketPlayOut {
	public void send(Player player);
	public PacketPlayOutEvent buildEvent();
}
