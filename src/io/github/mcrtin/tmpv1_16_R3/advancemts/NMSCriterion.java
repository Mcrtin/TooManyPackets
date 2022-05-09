package io.github.mcrtin.tmpv1_16_R3.advancemts;

import org.apache.commons.lang.Validate;
import org.bukkit.NamespacedKey;

import com.google.gson.JsonObject;

import io.github.mcrtin.tmp.PacketUtils;
import io.github.mcrtin.tmp.reflections.Field;
import lombok.NonNull;
import net.minecraft.server.v1_16_R3.Criterion;
import net.minecraft.server.v1_16_R3.CriterionInstance;
import net.minecraft.server.v1_16_R3.LootSerializationContext;
import net.minecraft.server.v1_16_R3.MinecraftKey;

public class NMSCriterion implements io.github.mcrtin.tmp.advancements.Criterion {
	@NonNull
	private Criterion nms;

	public NMSCriterion(NamespacedKey trigger, JsonObject conditions) {
		Validate.notNull(trigger);
		Validate.notNull(conditions);
	}

	public NMSCriterion(Criterion nms) {
		Validate.notNull(nms.a());
		this.nms = nms;
	}

	public Criterion getHandle() {
		return nms;
	}

	@Override
	public NamespacedKey getTrigger() {
		return PacketUtils.toNamespacedKey(nms.a().a());
	}

	@Override
	public void setTrigger(NamespacedKey trigger) {
		Field.set(nms, "a", new CriterionInstance() {

			@Override
			public JsonObject a(LootSerializationContext ctx) {
				return getConditions();
			}

			@Override
			public MinecraftKey a() {
				return PacketUtils.toMinecraftKey(trigger);
			}
		});
	}

	@Override
	public JsonObject getConditions() {
		return nms.a().a(LootSerializationContext.a);
	}

	@Override
	public void setConditions(JsonObject conditions) {
		Field.set(nms, "a", new CriterionInstance() {

			@Override
			public JsonObject a(LootSerializationContext ctx) {
				return conditions;
			}

			@Override
			public MinecraftKey a() {
				return nms.a().a();
			}
		});
	}

}