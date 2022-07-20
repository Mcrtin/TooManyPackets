package io.github.mcrtin.tmp.advancements;

import org.bukkit.NamespacedKey;

import com.google.gson.JsonObject;

import net.minecraft.server.v1_16_R3.CriterionTriggers;

import javax.annotation.Nullable;

public interface Criterion {
	/**
	 * @see CriterionTriggers
	 */
	@Nullable
	NamespacedKey getTrigger();

	@Nullable
	JsonObject getConditions();
}
