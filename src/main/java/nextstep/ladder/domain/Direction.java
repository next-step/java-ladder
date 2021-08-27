package nextstep.ladder.domain;

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
        if (prevInstall) {
            return LEFT;
        }

        if (currentInstall) {
            return RIGHT;
        }

        return NONE;
    }
}
