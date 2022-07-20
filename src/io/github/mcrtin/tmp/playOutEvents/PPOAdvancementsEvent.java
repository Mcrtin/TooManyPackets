package io.github.mcrtin.tmp.playOutEvents;

import java.util.Map;
import java.util.Set;

import io.github.mcrtin.tmp.playOutPackets.PPOAdvancements;
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
								@NonNull Map<NamespacedKey, Advancement> advancements,
								@NonNull Set<NamespacedKey> identifiers,
								@NonNull Map<NamespacedKey, AdvancementProgress> progresses) {
		super(injectedPlayer);

		this.reset = reset;
		this.advancements = advancements;
		this.identifiers = identifiers;
		this.progresses = progresses;
	}

	public PPOAdvancementsEvent(Player injectedPlayer, PPOAdvancements packet) {
		super(injectedPlayer);
		reset = packet.isReset();
		advancements = packet.getAdvancements();
		identifiers = packet.getIdentifiers();
		progresses = packet.getProgresses();
	}
}