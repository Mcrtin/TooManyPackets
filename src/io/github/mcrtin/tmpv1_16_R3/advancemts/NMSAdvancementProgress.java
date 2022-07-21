package io.github.mcrtin.tmpv1_16_R3.advancemts;

import io.github.mcrtin.tmp.reflections.Field;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import net.minecraft.server.v1_16_R3.AdvancementProgress;
import net.minecraft.server.v1_16_R3.CriterionProgress;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

@AllArgsConstructor
public class NMSAdvancementProgress implements io.github.mcrtin.tmp.advancements.AdvancementProgress {
	@NonNull
	private final AdvancementProgress nms;

	@SuppressWarnings("unchecked")
	public NMSAdvancementProgress(Map<String, Date> progress, String[][] requirements) {
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

	@Override
	public Map<String, Date> getProgress() {
		@SuppressWarnings("unchecked")
		Map<String, CriterionProgress> nmsCriterionProgresses = Field.get(nms, "a", Map.class);
		return nmsCriterionProgresses.entrySet().stream()
				.map(entry -> Map.entry(entry.getKey(), entry.getValue().getDate()))
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue));
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

	public AdvancementProgress getHandle() {
		return nms;
	}
}