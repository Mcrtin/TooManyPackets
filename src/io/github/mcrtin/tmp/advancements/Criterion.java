package io.github.mcrtin.tmp.advancements;

import org.bukkit.NamespacedKey;

import com.google.gson.JsonObject;

import net.minecraft.server.v1_16_R3.CriterionTriggers;

public interface Criterion {
	/**
	 * @see CriterionTriggers
	 */
	public NamespacedKey getTrigger();

	public void setTrigger(NamespacedKey trigger);

	public JsonObject getConditions();

	public void setConditions(JsonObject conditions);
}
