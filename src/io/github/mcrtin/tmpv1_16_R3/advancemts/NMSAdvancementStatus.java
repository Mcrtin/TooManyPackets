package io.github.mcrtin.tmpv1_16_R3.advancemts;

import org.apache.commons.lang.Validate;

import io.github.mcrtin.tmp.advancements.AdvancementStatus;
import net.minecraft.server.v1_16_R3.PacketPlayInAdvancements;

public enum NMSAdvancementStatus {
	;
	public static AdvancementStatus getAdvancementStatus(PacketPlayInAdvancements.Status nms) {
		Validate.notNull(nms);
		return switch (nms) {
		case CLOSED_SCREEN -> AdvancementStatus.CLOSED_SCREEN;
		case OPENED_TAB -> AdvancementStatus.OPENED_TAB;
		};
	}
	public static PacketPlayInAdvancements.Status getNMSAdvancementStatus(AdvancementStatus status) {
		Validate.notNull(status);
		return switch (status) {
		case CLOSED_SCREEN -> PacketPlayInAdvancements.Status.CLOSED_SCREEN;
		case OPENED_TAB -> PacketPlayInAdvancements.Status.OPENED_TAB;
		};
	}
}