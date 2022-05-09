package io.github.mcrtin.tmpv1_16_R3.playOut;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.bukkit.NamespacedKey;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import io.github.mcrtin.tmp.PacketUtils;
import io.github.mcrtin.tmp.advancements.Advancement;
import io.github.mcrtin.tmp.advancements.AdvancementProgress;
import io.github.mcrtin.tmp.playOutEvents.PPOAdvancementsEvent;
import io.github.mcrtin.tmp.playOutPackets.PPOAdvancements;
import io.github.mcrtin.tmp.reflections.Field;
import io.github.mcrtin.tmpv1_16_R3.advancemts.NMSAdvancement;
import io.github.mcrtin.tmpv1_16_R3.advancemts.NMSAdvancementProgress;
import lombok.NonNull;
import net.minecraft.server.v1_16_R3.Advancement.SerializedAdvancement;
import net.minecraft.server.v1_16_R3.MinecraftKey;
import net.minecraft.server.v1_16_R3.PacketPlayOutAdvancements;

public class NMSPPOAdvancements implements PPOAdvancements, NMSPacketPlayOut {
	@NonNull
	private final PacketPlayOutAdvancements packet;

	public NMSPPOAdvancements(PacketPlayOutAdvancements packet) {
		this.packet = packet;
	}

	@Override
	public void send(Player player) {
		((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
	}

	@Override
	public boolean isReset() {
		return Field.get(packet, "a", boolean.class);
	}

	@Override
	public Map<NamespacedKey, Advancement> getAdvancements() {
		Map<NamespacedKey, Advancement> advancements = new HashMap<>();

		@SuppressWarnings("unchecked")
		final Map<MinecraftKey, SerializedAdvancement> nmsAdvancements = Field.get(packet, "b", Map.class);

		for (Entry<MinecraftKey, SerializedAdvancement> entry : nmsAdvancements.entrySet())
			advancements.put(PacketUtils.toNamespacedKey(entry.getKey()), new NMSAdvancement(entry.getValue()));
		return advancements;
	}

	@Override
	public Set<NamespacedKey> getIdentifiers() {
		Set<NamespacedKey> identifiers = new HashSet<>();
		@SuppressWarnings("unchecked")
		final Set<MinecraftKey> nmsIdentifiers = Field.get(packet, "c", Set.class);
		for (MinecraftKey minecraftKey : nmsIdentifiers)
			identifiers.add(PacketUtils.toNamespacedKey(minecraftKey));
		return identifiers;
	}

	@Override
	public Map<NamespacedKey, AdvancementProgress> getProgresses() {
		Map<NamespacedKey, AdvancementProgress> progresses = new HashMap<>();
		@SuppressWarnings("unchecked")
		final Map<MinecraftKey, net.minecraft.server.v1_16_R3.AdvancementProgress> nmsProgresses = Field.get(packet,
				"d", Map.class);
		for (Entry<MinecraftKey, net.minecraft.server.v1_16_R3.AdvancementProgress> entry : nmsProgresses.entrySet())
			progresses.put(PacketUtils.toNamespacedKey(entry.getKey()), new NMSAdvancementProgress(entry.getValue()));
		return progresses;
	}

	@Override
	public PPOAdvancementsEvent buildEvent(Player player) {
		return new PPOAdvancementsEvent(player, isReset(), getAdvancements(), getIdentifiers(), getProgresses());
	}
}