package io.github.mcrtin.tmpv1_16_R3.advancemts;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.Validate;

import io.github.mcrtin.tmp.reflections.Field;
import lombok.NonNull;
import net.minecraft.server.v1_16_R3.AdvancementProgress;
import net.minecraft.server.v1_16_R3.CriterionProgress;

public class NMSAdvancementProgress implements io.github.mcrtin.tmp.advancements.AdvancementProgress {
	@NonNull
	private AdvancementProgress nms;

	@SuppressWarnings("unchecked")
	public NMSAdvancementProgress(Map<String, Date> progress, String[][] requirements) {
		Validate.notNull(progress);
		Validate.notNull(requirements);
		nms = new AdvancementProgress();
		Map<String, CriterionProgress> nmsCriterionProgresses = new HashMap<>();
		for (Entry<String, Date> entry : progress.entrySet()) {
			final CriterionProgress value = new CriterionProgress();
			Field.set(value, "b", entry.getValue());
			nmsCriterionProgresses.put(entry.getKey(), value);
		}
		Field.get(nms, "a", Map.class).putAll(nmsCriterionProgresses);
		Field.set(nms, "b", requirements);
	}

	public NMSAdvancementProgress(AdvancementProgress nms) {
		Validate.notNull(nms);
		this.nms = nms;
	}

	@Override
	public Map<String, Date> getProgress() {
		@SuppressWarnings("unchecked")
		Map<String, CriterionProgress> nmsCriterionProgresses = Field.get(nms, "a", Map.class);
		Map<String, Date> progress = new HashMap<>();
		for (Entry<String, CriterionProgress> entry : nmsCriterionProgresses.entrySet())
			progress.put(entry.getKey(), entry.getValue().getDate());
		return progress;
	}

	@Override
	public void setProgress(Map<String, Date> progress) {
		Map<String, CriterionProgress> nmsCriterionProgresses = new HashMap<>();
		for (Entry<String, Date> entry : progress.entrySet()) {
			final CriterionProgress value = new CriterionProgress();
			Field.set(value, "b", entry.getValue());
			nmsCriterionProgresses.put(entry.getKey(), value);
		}
		Field.set(nms, "a", nmsCriterionProgresses);
	}

	@Override
	public String[][] getRequirements() {
		return Field.get(nms, "b", String[][].class);
	}

	@Override
	public void setRequirements(String[][] requirements) {
		Field.set(nms, "b", requirements);
	}

	public AdvancementProgress getHadle() {
		return nms;
	}
}