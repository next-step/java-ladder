package nextstep.ladder.domain;

import java.util.Optional;
import java.util.function.IntUnaryOperator;

public enum Direction {
    NONE(position -> position),
    LEFT(position -> position - 1),
    RIGHT(position -> position + 1);

    private final IntUnaryOperator move;

    Direction(final IntUnaryOperator move) {
        this.move = move;
    }

    public int move(int position) {
        return move.applyAsInt(position);
    }

    public static Direction decide(final boolean prevInstall, final boolean currentInstall) {
        return Optional.of(prevInstall)
                .filter(prev -> prev)
                .map(prev -> LEFT)
                .orElseGet(() -> Optional.of(currentInstall)
                        .filter(current -> current)
                        .map(current -> RIGHT)
                        .orElse(NONE));
    }
}
