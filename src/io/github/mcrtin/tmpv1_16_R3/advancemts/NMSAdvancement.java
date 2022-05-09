package io.github.mcrtin.tmpv1_16_R3.advancemts;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Nullable;

import org.apache.commons.lang.Validate;
import org.bukkit.NamespacedKey;

import io.github.mcrtin.tmp.PacketUtils;
import io.github.mcrtin.tmp.advancements.Advancement;
import io.github.mcrtin.tmp.advancements.Criterion;
import io.github.mcrtin.tmp.advancements.Display;
import io.github.mcrtin.tmp.advancements.Rewards;
import io.github.mcrtin.tmp.reflections.Field;
import lombok.NonNull;
import net.minecraft.server.v1_16_R3.Advancement.SerializedAdvancement;
import net.minecraft.server.v1_16_R3.AdvancementDisplay;
import net.minecraft.server.v1_16_R3.AdvancementRewards;
import net.minecraft.server.v1_16_R3.MinecraftKey;

public class NMSAdvancement implements Advancement {
	@NonNull
	private SerializedAdvancement nms;

	public NMSAdvancement(SerializedAdvancement nms) {
		Validate.notNull(nms);
		this.nms = nms;

	}

	@Nullable
	@Override
	public NamespacedKey getParent() {
		final MinecraftKey nmsParent = Field.get(nms, "a", MinecraftKey.class);
		NamespacedKey parent = nmsParent == null ? null : PacketUtils.toNamespacedKey(nmsParent);
		return parent;
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
		nms.a(((NMSDisplay) display).getHandle());
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
		Map<String, Criterion> criteria = new HashMap<>();
		for (Entry<String, net.minecraft.server.v1_16_R3.Criterion> entry : nmsCriteria.entrySet())
			criteria.put(entry.getKey(), new NMSCriterion(entry.getValue()));
		return criteria;
	}

	@Override
	public void setCriteria(Map<String, Criterion> criteria) {
		Map<String, net.minecraft.server.v1_16_R3.Criterion> nmsCriteria = new HashMap<>();
		for (Entry<String, Criterion> entry : criteria.entrySet())
			nmsCriteria.put(entry.getKey(), ((NMSCriterion) entry.getValue()).getHandle());
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