package io.github.mcrtin.tmp.advancements;

import java.util.Date;
import java.util.Map;

public interface AdvancementProgress {
	public Map<String, Date> getProgress();

	public void setProgress(Map<String, Date> progress);

	public String[][] getRequirements();

	public void setRequirements(String[][] requirements);

}
