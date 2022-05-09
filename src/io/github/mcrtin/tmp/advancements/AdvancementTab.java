package io.github.mcrtin.tmp.advancements;

import org.apache.commons.lang.Validate;

public enum AdvancementTab {
	STORY("story/root"), NETHER("nether/root"), END("end/root"), ADVENTURE("adventure/root"),
	HUSBANDRY("husbandry/root");

	private final String identifier;

	private AdvancementTab(String identifier) {
		this.identifier = identifier;
	}

	public String getIdentifier() {
		return identifier;
	}

	public static AdvancementTab getAdvancementTab(String identifier) {
		Validate.notNull(identifier);
		for (AdvancementTab tab : AdvancementTab.values())
			if (tab.getIdentifier().equals(identifier))
				return tab;
		throw new IllegalArgumentException();
	}
}