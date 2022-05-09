package io.github.mcrtin.tmp.playOutPackets;

import java.util.Map;
import java.util.Set;

import org.bukkit.NamespacedKey;

import io.github.mcrtin.tmp.advancements.Advancement;
import io.github.mcrtin.tmp.advancements.AdvancementProgress;

public interface PPOAdvancements {
	public boolean isReset();
	public Map<NamespacedKey, Advancement> getAdvancements();
	public Set<NamespacedKey> getIdentifiers();
	public Map<NamespacedKey, AdvancementProgress> getProgresses();
}