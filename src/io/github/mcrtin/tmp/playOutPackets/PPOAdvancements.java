package io.github.mcrtin.tmp.playOutPackets;

import java.util.Map;
import java.util.Set;

import org.bukkit.NamespacedKey;

import io.github.mcrtin.tmp.advancements.Advancement;
import io.github.mcrtin.tmp.advancements.AdvancementProgress;

public interface PPOAdvancements extends PacketPlayOut{
	boolean isReset();
	Map<NamespacedKey, Advancement> getAdvancements();
	Set<NamespacedKey> getIdentifiers();
	Map<NamespacedKey, AdvancementProgress> getProgresses();
}