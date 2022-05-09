package io.github.mcrtin.tmp.playOutEvents;

import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.Validate;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;

import io.github.mcrtin.tmp.advancements.Advancement;
import io.github.mcrtin.tmp.advancements.AdvancementProgress;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class PPOAdvancementsEvent extends PacketPlayOutEvent {

	/**
	 * Whether to reset/clear the current advancements.
	 */
	private boolean reset;
	@NonNull
	private Map<NamespacedKey, Advancement> advancements;

	/**
	 * The identifiers of the advancements that should be removed.
	 */
	@NonNull
	private Set<NamespacedKey> identifiers;
	@NonNull
	private Map<NamespacedKey, AdvancementProgress> progresses;

	public PPOAdvancementsEvent(Player injectedPlayer, boolean reset,
			Map<NamespacedKey, Advancement> advancements, Set<NamespacedKey> identifiers,
			Map<NamespacedKey, AdvancementProgress> progresses) {
		super(injectedPlayer);

		Validate.notNull(advancements);
		Validate.notNull(identifiers);
		Validate.notNull(progresses);

		this.reset = reset;
		this.advancements = advancements;
		this.identifiers = identifiers;
		this.progresses = progresses;
	}
}