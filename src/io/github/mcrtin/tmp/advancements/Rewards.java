package io.github.mcrtin.tmp.advancements;

import org.bukkit.NamespacedKey;

public interface Rewards {
	int getXp();

	void setXp(int xp);

	NamespacedKey[] getLoot();

	void setLoot(NamespacedKey[] loot);

	NamespacedKey[] getRecipes();

	void setRecipes(NamespacedKey[] recipes);

	Object getCustomFunction();

	void setCustomFunction(Object function);
}
