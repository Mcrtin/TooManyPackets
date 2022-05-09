package io.github.mcrtin.tmp.advancements;

import java.util.Map;

import javax.annotation.Nullable;

import org.bukkit.NamespacedKey;


public interface Advancement {
	
	@Nullable
	public NamespacedKey getParent();

	public void setParent(@Nullable NamespacedKey parent);

	@Nullable
	public Display getDisplay();

	public void setDisplay(@Nullable Display display);

	public Rewards getRewards();

	public void setRewards(Rewards rewards);

	public Map<String, Criterion> getCriteria();

	public void setCriteria(Map<String, Criterion> criteria);

	public String[][] getRequirements();

	public void setRequirements(String[][] requirements);
}
