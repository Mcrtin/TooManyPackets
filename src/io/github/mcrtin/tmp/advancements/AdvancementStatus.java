package io.github.mcrtin.tmp.advancements;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum AdvancementStatus {
	OPENED_TAB(0),
	CLOSED_SCREEN(1);

	private final int id;

	public static AdvancementStatus getById(int id) {
		return Arrays.stream(values())
				.filter(status -> status.id == id)
				.findAny()
				.orElseThrow(IllegalArgumentException::new);
	}
}
