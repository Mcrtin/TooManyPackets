package io.github.mcrtin.tmpv1_16_R3.advancemts;

import io.github.mcrtin.tmp.advancements.Advancement;
import io.github.mcrtin.tmp.advancements.Criterion;
import io.github.mcrtin.tmp.advancements.Display;
import io.github.mcrtin.tmp.advancements.Rewards;
import io.github.mcrtin.tmp.reflections.Field;
import io.github.mcrtin.tmpv1_16_R3.PacketUtils;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import net.minecraft.server.v1_16_R3.Advancement.SerializedAdvancement;
import net.minecraft.server.v1_16_R3.AdvancementDisplay;
import net.minecraft.server.v1_16_R3.AdvancementRewards;
import net.minecraft.server.v1_16_R3.MinecraftKey;
import org.bukkit.NamespacedKey;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

@AllArgsConstructor
public class NMSAdvancement implements Advancement {
	@NonNull
	private final SerializedAdvancement nms;

	@Nullable
	@Override
	public NamespacedKey getParent() {
		final MinecraftKey nmsParent = Field.get(nms, "a", MinecraftKey.class);
		return nmsParent == null ? null : PacketUtils.toNamespacedKey(nmsParent);
	}

	@Override
	public void setParent(@Nullable NamespacedKey parent) {
		nms.a(PacketUtils.toMinecraftKey(parent));
	}

	@Nullable
	@Override
	public Display getDisplay() {
		final AdvancementDisplay nmsDisplay = Field.get(nms, "c", AdvancementDisplay.class);
		return nmsDisplay == null ? null : new NMSDisplay(nmsDisplay);
	}

	@Override
	public void setDisplay(@Nullable Display display) {
		nms.a(display == null ? null : ((NMSDisplay) display).getHandle());
	}

	@Override
	public Rewards getRewards() {
		return new NMSRewards(Field.get(nms, "d", AdvancementRewards.class));
	}

	@Override
	public void setRewards(Rewards rewards) {
		nms.a(((NMSRewards) rewards).getHandle());
	}

	@Override
	public Map<String, Criterion> getCriteria() {
		@SuppressWarnings("unchecked")
		final Map<String, net.minecraft.server.v1_16_R3.Criterion> nmsCriteria = Field.get(nms, "e", Map.class);
		return nmsCriteria.entrySet().stream()
				.map(entry -> Map.entry(entry.getKey(), new NMSCriterion(entry.getValue())))
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue));
	}

	@Override
	public void setCriteria(Map<String, Criterion> criteria) {
		Field.set(nms, "e", criteria.entrySet().stream()
		.map(entry -> Map.entry(entry.getKey(), ((NMSCriterion) entry.getValue()).getHandle()))
		.collect(Collectors.toMap(Entry::getKey, Entry::getValue)));
	}

	@Override
	public String[][] getRequirements() {
		return Field.get(nms, "f", String[][].class);
	}

	@Override
	public void setRequirements(String[][] requirements) {
		Field.set(nms, "f", requirements);
	}

}