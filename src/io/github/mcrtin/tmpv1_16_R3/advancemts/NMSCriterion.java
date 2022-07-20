package io.github.mcrtin.tmpv1_16_R3.advancemts;

import org.apache.commons.lang.Validate;
import org.bukkit.NamespacedKey;

import com.google.gson.JsonObject;

import io.github.mcrtin.tmpv1_16_R3.PacketUtils;
import lombok.NonNull;
import net.minecraft.server.v1_16_R3.Criterion;
import net.minecraft.server.v1_16_R3.CriterionInstance;
import net.minecraft.server.v1_16_R3.LootSerializationContext;

public class NMSCriterion implements io.github.mcrtin.tmp.advancements.Criterion {
	@NonNull
	private Criterion nms;

	public NMSCriterion(Criterion nms) {
		Validate.notNull(nms.a());
		this.nms = nms;
	}

	public Criterion getHandle() {
		return nms;
	}

	@Override
	public NamespacedKey getTrigger() {
		CriterionInstance criterionInstance = nms.a();
		return criterionInstance == null ? null : PacketUtils.toNamespacedKey(criterionInstance.a());
	}

	@Override
	public JsonObject getConditions() {
		CriterionInstance criterionInstance = nms.a();
		return criterionInstance == null ? null : criterionInstance.a(LootSerializationContext.a);
	}

}