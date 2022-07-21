package io.github.mcrtin.tmp.playOutEvents;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

@Getter
@Setter
public abstract class PacketPlayOutEntityEvent extends PacketPlayOutEvent {

	private int entityId;
	private Entity entity;
	public PacketPlayOutEntityEvent(Player injectedPlayer, int entityId, Entity entity) {
		super(injectedPlayer);
		this.entityId = entityId;
		this.entity = entity;
	}
}