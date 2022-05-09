package io.github.mcrtin.tmp.advancements;

import org.bukkit.NamespacedKey;

import net.minecraft.server.v1_16_R3.CustomFunction;

public interface Rewards {
	public int getXp();

	public void setXp(int xp);

	public NamespacedKey[] getLoot();

	public void setLoot(NamespacedKey[] loot);

	public NamespacedKey[] getRecipes();

	public void setRecipes(NamespacedKey[] recipes);

	public CustomFunction.a getFunction();

	public void setFunction(CustomFunction.a function);
}
