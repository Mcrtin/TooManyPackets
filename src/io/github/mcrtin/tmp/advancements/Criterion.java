package io.github.mcrtin.tmp.advancements;

import org.bukkit.NamespacedKey;

import com.google.gson.JsonObject;

import javax.annotation.Nullable;

public interface Criterion {
	@Nullable
	NamespacedKey getTrigger();

	@Nullable
	JsonObject getConditions();
}
