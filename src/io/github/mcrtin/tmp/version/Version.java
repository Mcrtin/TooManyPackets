package io.github.mcrtin.tmp.version;

import org.bukkit.Bukkit;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Version {
	v1_16_R3("v1_16_R3")
	;
	public static final Version currentVersion = calcCurrentVersion();
	private final String versionString;
	public static Version calcCurrentVersion() {
		String currentVersionString = Bukkit.getVersion();
		for (Version v : values())
			if (v.versionString.equals(currentVersionString))
				return v;
		throw new UnsupportedVersionExeption();
	}
}
