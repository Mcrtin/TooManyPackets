package io.github.mcrtin.tmpv1_16_R3.advancemts;

import org.apache.commons.lang.Validate;
import org.bukkit.NamespacedKey;

import io.github.mcrtin.tmp.PacketUtils;
import io.github.mcrtin.tmp.advancements.Rewards;
import io.github.mcrtin.tmp.reflections.Field;
import lombok.NonNull;
import net.minecraft.server.v1_16_R3.AdvancementRewards;
import net.minecraft.server.v1_16_R3.CustomFunction;
import net.minecraft.server.v1_16_R3.MinecraftKey;

public class NMSRewards implements Rewards {
	@NonNull
	private AdvancementRewards nms;

	public NMSRewards(int xp, NamespacedKey[] loot, NamespacedKey[] recipes, CustomFunction.a function) {
		Validate.notNull(loot);
		Validate.notNull(recipes);
		Validate.notNull(function);

		MinecraftKey[] nmsLoot = new MinecraftKey[loot.length];
		MinecraftKey[] nmsRecipes = new MinecraftKey[recipes.length];

		for (int i = 0; i < loot.length; i++)
			nmsLoot[i] = PacketUtils.toMinecraftKey(loot[i]);
		for (int i = 0; i < recipes.length; i++)
			nmsRecipes[i] = PacketUtils.toMinecraftKey(recipes[i]);

		nms = new AdvancementRewards(xp, nmsLoot, nmsRecipes, function);
	}

	public NMSRewards(AdvancementRewards nms) {
		Validate.notNull(nms);
		this.nms = nms;
	}

	public int getXp() {
		return Field.get(nms, "b", int.class);
	}

	public void setXp(int xp) {
		Field.set(nms, "b", xp);
	}

	public NamespacedKey[] getLoot() {
		MinecraftKey[] nmsLoot = Field.get(nms, "c", MinecraftKey[].class);
		NamespacedKey[] loot = new NamespacedKey[nmsLoot.length];
		for (int i = 0; i < nmsLoot.length; i++)
			loot[i] = PacketUtils.toNamespacedKey(nmsLoot[i]);
		return loot;
	}

	public void setLoot(NamespacedKey[] loot) {
		Validate.notNull(loot);
		Field.set(nms, "c", loot);
	}

	public NamespacedKey[] getRecipes() {
		MinecraftKey[] nmsRecipes = Field.get(nms, "d", MinecraftKey[].class);
		NamespacedKey[] recipes = new NamespacedKey[nmsRecipes.length];
		for (int i = 0; i < nmsRecipes.length; i++)
			recipes[i] = PacketUtils.toNamespacedKey(nmsRecipes[i]);
		return recipes;
	}

	public void setRecipes(NamespacedKey[] recipes) {
		Validate.notNull(recipes);
		Field.set(nms, "d", recipes);
	}

	public CustomFunction.a getFunction() {
		return Field.get(nms, "e", CustomFunction.a.class);
	}

	public void setFunction(CustomFunction.a function) {
		Validate.notNull(function);
		Field.set(nms, "e", function);
	}

	public AdvancementRewards getHandle() {
		return nms;
	}

}