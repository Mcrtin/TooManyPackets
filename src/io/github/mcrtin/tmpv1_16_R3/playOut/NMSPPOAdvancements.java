package io.github.mcrtin.tmpv1_16_R3.playOut;

import io.github.mcrtin.tmp.advancements.Advancement;
import io.github.mcrtin.tmp.advancements.AdvancementProgress;
import io.github.mcrtin.tmp.playOutEvents.PPOAdvancementsEvent;
import io.github.mcrtin.tmp.playOutPackets.PPOAdvancements;
import io.github.mcrtin.tmp.reflections.Field;
import io.github.mcrtin.tmpv1_16_R3.PacketUtils;
import io.github.mcrtin.tmpv1_16_R3.advancemts.NMSAdvancement;
import io.github.mcrtin.tmpv1_16_R3.advancemts.NMSAdvancementProgress;
import lombok.NonNull;
import net.minecraft.server.v1_16_R3.Advancement.SerializedAdvancement;
import net.minecraft.server.v1_16_R3.MinecraftKey;
import net.minecraft.server.v1_16_R3.Packet;
import net.minecraft.server.v1_16_R3.PacketPlayOutAdvancements;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class NMSPPOAdvancements implements PPOAdvancements {
	@NonNull
	private final PacketPlayOutAdvancements packet;

	public NMSPPOAdvancements(@NonNull PacketPlayOutAdvancements packet) {
		this.packet = packet;
	}

	@Override
	public void send(Player player) {
		PacketUtils.sendPacket(player, packet);
	}

	@Override
	public boolean isReset() {
		return Field.get(packet, "a", boolean.class);
	}

	@Override
	public Map<NamespacedKey, Advancement> getAdvancements() {
		@SuppressWarnings("unchecked")
		final Map<MinecraftKey, SerializedAdvancement> nmsAdvancements = Field.get(packet, "b", Map.class);
		return  nmsAdvancements.entrySet().stream()
				.map(entry -> Map.entry(PacketUtils.toNamespacedKey(entry.getKey()),  new NMSAdvancement(entry.getValue())))
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue));
	}

	@Override
	public Set<NamespacedKey> getIdentifiers() {
		@SuppressWarnings("unchecked")
		final Set<MinecraftKey> nmsIdentifiers = Field.get(packet, "c", Set.class);
		return nmsIdentifiers.stream()
				.map(PacketUtils::toNamespacedKey)
				.collect(Collectors.toSet());
	}

	@Override
	public Map<NamespacedKey, AdvancementProgress> getProgresses() {
		@SuppressWarnings("unchecked")
		final Map<MinecraftKey, net.minecraft.server.v1_16_R3.AdvancementProgress> nmsProgresses = Field.get(packet,
				"d", Map.class);
		return nmsProgresses.entrySet().stream()
				.map(entry -> Map.entry(PacketUtils.toNamespacedKey(entry.getKey()), new NMSAdvancementProgress(entry.getValue())))
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue));

	}

	@Override
	public PPOAdvancementsEvent buildEvent(Player player) {
		return new PPOAdvancementsEvent(player, this);
	}

	public Packet<?> getHandle() {
		return packet;
	}
}