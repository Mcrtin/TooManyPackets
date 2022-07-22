package io.github.mcrtin.tmp.player;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum CombatType {
    ENTER_COMBAT(0),
    END_COMBAT(1),
    ENTITY_DIED(2);
    private final int id;

    public static CombatType getById(int id) {
        return Arrays.stream(values())
                .filter(type -> type.id == id)
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
