package io.github.mcrtin.tmp.advancements;

import java.util.Map;

import javax.annotation.Nullable;

import org.bukkit.NamespacedKey;


public interface Advancement {
	
	@Nullable
	NamespacedKey getParent();

	void setParent(@Nullable NamespacedKey parent);

	@Nullable
	Display getDisplay();

	void setDisplay(@Nullable Display display);

	Rewards getRewards();

	void setRewards(Rewards rewards);

	Map<String, Criterion> getCriteria();

	void setCriteria(Map<String, Criterion> criteria);

	String[][] getRequirements();

	void setRequirements(String[][] requirements);
}
