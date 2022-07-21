package io.github.mcrtin.tmp.version;

import io.github.mcrtin.tmp.GameInterface;
import lombok.AllArgsConstructor;
import org.bukkit.Bukkit;

import java.util.Arrays;
@AllArgsConstructor
public enum Version {
	v1_16_R3("v1_16_R3", "io.github.mcrtin.tmpv1_16_R3.NMSGameInterface")
	;
	public static final Version CURRENT_VERSION = Arrays.stream(values())
			.filter(v -> v.versionString.equals(Bukkit.getVersion()))
			.findAny()
			.orElseThrow(UnsupportedVersionExeption::new);
	private final String versionString;
	private final String injections;

	@SuppressWarnings("unchecked")
	public Class<? extends GameInterface> getInjections() throws ClassNotFoundException {
		return (Class<? extends GameInterface>) Class.forName(injections);
	}
}
