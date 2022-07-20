package io.github.mcrtin.tmp.advancements;

import lombok.NonNull;

import java.util.Arrays;

public enum AdvancementTab {
	STORY("story/root"), NETHER("nether/root"), END("end/root"), ADVENTURE("adventure/root"),
	HUSBANDRY("husbandry/root");

	private final String identifier;

	AdvancementTab(String identifier) {
		this.identifier = identifier;
	}

	public String getIdentifier() {
		return identifier;
	}

	public static AdvancementTab getAdvancementTab(@NonNull String identifier) {
		return Arrays.stream(values())
				.filter(tab -> tab.getIdentifier().equals(identifier))
				.findAny()
				.orElseThrow(IllegalArgumentException::new);
	}
}