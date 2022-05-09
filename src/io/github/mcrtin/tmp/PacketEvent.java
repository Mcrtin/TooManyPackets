package io.github.mcrtin.tmp;

import org.apache.commons.lang.Validate;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacketEvent extends Event implements Cancellable {

	private static HandlerList handlers = new HandlerList();

	public static HandlerList getHandlerList() {
		return handlers;
	}

	private boolean cancelled = false;

	private final Player player;

	private final PacketType packetType;

	public PacketEvent(Player player, PacketType packetType) {
		super(true);

		Validate.notNull(player);
		Validate.notNull(packetType);

		this.player = player;
		this.packetType = packetType;
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

}