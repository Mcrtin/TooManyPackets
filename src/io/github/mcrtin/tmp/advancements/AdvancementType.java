package io.github.mcrtin.tmp.advancements;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum AdvancementType {
	TASK("task"),
	CHALLENGE("challenge"),
	GOAL("goal");

	private final String id;

	public static AdvancementType getById(String id) {
		return Arrays.stream(values())
				.filter(type -> type.id.equals(id))
				.findAny()
				.orElseThrow(IllegalArgumentException::new);
	}
}
