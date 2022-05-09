package io.github.mcrtin.tmpv1_16_R3.advancemts;

import org.apache.commons.lang.Validate;

import io.github.mcrtin.tmp.advancements.AdvancementType;
import net.minecraft.server.v1_16_R3.AdvancementFrameType;

public enum NMSAdvancementType {
	;

	public static AdvancementType getAdvancementTypeOf(AdvancementFrameType nms) {
		Validate.notNull(nms);
		return switch (nms) {
		case TASK -> AdvancementType.TASK;
		case CHALLENGE -> AdvancementType.CHALLENGE;
		case GOAL -> AdvancementType.GOAL;
		};
	}

	public static AdvancementFrameType getAdvancementTypeOf(AdvancementType type) {
		Validate.notNull(type);
		return switch (type) {
		case TASK -> AdvancementFrameType.TASK;
		case CHALLENGE -> AdvancementFrameType.CHALLENGE;
		case GOAL -> AdvancementFrameType.GOAL;
		};
	}
}