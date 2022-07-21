package io.github.mcrtin.tmp.block;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum BlockAction {

    MOB_SPAWNER(1),

    COMMAND_BLOCK(2),

    BEACON(3),

    MOB_HEAD(4),

    CONDUIT(5),

    BANNER(6),

    STRUCTURE_BLOCK(7),

    END_GATEWAY(8),

    SIGN(9),

    UNUSED(10),

    BED(11),

    JIGSAW_BLOCK(12),

    CAMPFIRE(13),

    BEEHIVE(14);

    private final int id;

    public static BlockAction getById(int id) {
        return Arrays.stream(values())
                .filter(action -> action.id == id)
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
