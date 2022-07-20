package io.github.mcrtin.tmp.version;

import org.bukkit.Bukkit;

import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public enum Version {
	v1_16_R3("v1_16_R3")
	;
	public static final Version currentVersion = Arrays.stream(values())
			.filter(v -> v.versionString.equals(Bukkit.getVersion()))
			.findAny()
			.orElseThrow(UnsupportedVersionExeption::new);
	private final String versionString;
}
