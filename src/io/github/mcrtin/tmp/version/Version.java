package io.github.mcrtin.tmp.version;

import org.bukkit.Bukkit;

import lombok.AllArgsConstructor;
import org.bukkit.event.Listener;

import java.util.Arrays;
@AllArgsConstructor
public enum Version {
	v1_16_R3("v1_16_R3", "io.github.mcrtin.tmpv1_16_R3.Injections")
	;
	public static final Version currentVersion = Arrays.stream(values())
			.filter(v -> v.versionString.equals(Bukkit.getVersion()))
			.findAny()
			.orElseThrow(UnsupportedVersionExeption::new);
	private final String versionString;
	private final String injections;

	@SuppressWarnings("unchecked")
	public Class<? extends Listener> getInjections() throws ClassNotFoundException {
		return (Class<? extends Listener>) Class.forName(injections);
	}
}
