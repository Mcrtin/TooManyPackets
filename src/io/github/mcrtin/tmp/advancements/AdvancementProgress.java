package io.github.mcrtin.tmp.advancements;

import java.util.Date;
import java.util.Map;

public interface AdvancementProgress {
	Map<String, Date> getProgress();

	void setProgress(Map<String, Date> progress);

	String[][] getRequirements();

	void setRequirements(String[][] requirements);

}
