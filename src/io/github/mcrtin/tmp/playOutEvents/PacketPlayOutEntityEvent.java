package io.github.mcrtin.tmp.playOutEvents;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_16_R3.CraftServer;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftEntity;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import io.github.mcrtin.tmp.reflections.Field;
import net.minecraft.server.v1_16_R3.Packet;
import net.minecraft.server.v1_16_R3.PacketListenerPlayOut;

import javax.annotation.Nullable;

@Getter
@Setter
public abstract class PacketPlayOutEntityEvent extends PacketPlayOutEvent {

	private int entityId;

	public PacketPlayOutEntityEvent(Player injectedPlayer, int entityId) {
		super(injectedPlayer);
		this.entityId = entityId;
	}

	protected PacketPlayOutEntityEvent(Player injectedPlayer, Packet<PacketListenerPlayOut> packet) {
		this(injectedPlayer, packet, "a");
	}

	protected PacketPlayOutEntityEvent(Player injectedPlayer, Packet<PacketListenerPlayOut> packet, String fieldName) {
		super(injectedPlayer);
		this.entityId = Field.get(packet, fieldName, int.class);
	}

	@Nullable
	public Entity getEntity() {
		return CraftEntity.getEntity((CraftServer) Bukkit.getServer(),((CraftWorld)getPlayer().getWorld()).getHandle().getEntity(entityId));
	}

}