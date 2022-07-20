package io.github.mcrtin.tmp.advancements;

import org.bukkit.NamespacedKey;

import net.minecraft.server.v1_16_R3.CustomFunction;

public interface Rewards {
	int getXp();

	void setXp(int xp);

	NamespacedKey[] getLoot();

	void setLoot(NamespacedKey[] loot);

	NamespacedKey[] getRecipes();

	void setRecipes(NamespacedKey[] recipes);

	CustomFunction.a getFunction();

	void setFunction(CustomFunction.a function);
}
