package io.github.mcrtin.tmp;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
public class PacketEvent extends Event implements Cancellable {

	@NotNull
	private static HandlerList handlers = new HandlerList();

	@NonNull
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	@NotNull
	public static HandlerList getHandlerList() {
		return handlers;
	}

	private boolean cancelled = false;

	@NotNull
	private final Player player;

	@NotNull
	private final PacketType packetType;

	public PacketEvent(@NotNull Player player, @NotNull PacketType packetType) {
		super(true);

		this.player = player;
		this.packetType = packetType;
	}

}