package io.github.mcrtin.tmpv1_16_R3.advancemts;

import io.github.mcrtin.tmp.advancements.Rewards;
import io.github.mcrtin.tmp.reflections.Field;
import io.github.mcrtin.tmpv1_16_R3.PacketUtils;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import net.minecraft.server.v1_16_R3.AdvancementRewards;
import net.minecraft.server.v1_16_R3.CustomFunction;
import net.minecraft.server.v1_16_R3.MinecraftKey;
import org.bukkit.NamespacedKey;

@AllArgsConstructor
public class NMSRewards implements Rewards {
	@NonNull
	private final AdvancementRewards nms;

	public NMSRewards(int xp, NamespacedKey[] loot, NamespacedKey[] recipes, CustomFunction.a function) {

		MinecraftKey[] nmsLoot = new MinecraftKey[loot.length];
		MinecraftKey[] nmsRecipes = new MinecraftKey[recipes.length];

		for (int i = 0; i < loot.length; i++)
			nmsLoot[i] = PacketUtils.toMinecraftKey(loot[i]);
		for (int i = 0; i < recipes.length; i++)
			nmsRecipes[i] = PacketUtils.toMinecraftKey(recipes[i]);

		nms = new AdvancementRewards(xp, nmsLoot, nmsRecipes, function);
	}

	@Override
	public int getXp() {
		return Field.get(nms, "b", int.class);
	}

	@Override
	public void setXp(int xp) {
		Field.set(nms, "b", xp);
	}

	@Override
	public NamespacedKey[] getLoot() {
		MinecraftKey[] nmsLoot = Field.get(nms, "c", MinecraftKey[].class);
		NamespacedKey[] loot = new NamespacedKey[nmsLoot.length];
		for (int i = 0; i < nmsLoot.length; i++)
			loot[i] = PacketUtils.toNamespacedKey(nmsLoot[i]);
		return loot;
	}

	@Override
	public void setLoot(NamespacedKey[] loot) {
		Field.set(nms, "c", loot);
	}

	@Override
	public NamespacedKey[] getRecipes() {
		MinecraftKey[] nmsRecipes = Field.get(nms, "d", MinecraftKey[].class);
		NamespacedKey[] recipes = new NamespacedKey[nmsRecipes.length];
		for (int i = 0; i < nmsRecipes.length; i++)
			recipes[i] = PacketUtils.toNamespacedKey(nmsRecipes[i]);
		return recipes;
	}

	@Override
	public void setRecipes(NamespacedKey[] recipes) {
		Field.set(nms, "d", recipes);
	}

	@Override
	public CustomFunction.a getCustomFunction() {
		return Field.get(nms, "e", CustomFunction.a.class);
	}

	@Override
	public void setCustomFunction(Object function) {
		Field.set(nms, "e", function);
	}

	public AdvancementRewards getHandle() {
		return nms;
	}

}