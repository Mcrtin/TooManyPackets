package io.github.mcrtin.tmp.bossBar;

import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public enum BossBarAction {
    ADD(0),
    REMOVE(1),
    UPDATE_HEALTH(2),
    UPDATE_TITLE(3),
    UPDATE_STYLE(4),
    UPDATE_PROPERTIES(5);

    private final int id;

    public static BossBarAction getById(int id) {
        return Arrays.stream(values())
                .filter(action -> action.id == id)
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
