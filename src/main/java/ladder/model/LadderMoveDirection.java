package ladder.model;

import java.util.function.Function;

public enum LadderMoveDirection {
    LEFT(position -> position - 1),
    STAY(position -> position),
    RIGHT(position -> position + 1),
    ;

    private final Function<Integer, Integer> move;

    LadderMoveDirection(final Function<Integer, Integer> move) {
        this.move = move;
    }
}
