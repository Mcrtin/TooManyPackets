package io.github.mcrtin.tmp.playOutEvents;

import io.github.mcrtin.tmp.TooManyPackets;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;

@Getter
@Setter
public abstract class PacketPlayOutEntityEvent extends PacketPlayOutEvent {

	private int entityId;
	@Nullable
	private Entity entity;
	public PacketPlayOutEntityEvent(Player injectedPlayer, int entityId) {
		super(injectedPlayer);
		this.entityId = entityId;
		this.entity = TooManyPackets.getEntityById(entityId, injectedPlayer.getWorld());
	}
}