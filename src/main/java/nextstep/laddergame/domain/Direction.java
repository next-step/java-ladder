package nextstep.laddergame.domain;

import java.util.function.Function;

public enum Direction {
    LEFT(index -> index - 1),
    RIGHT(index -> index + 1),
    DOWN(index -> index);

    private final Function<Integer, Integer> mover;

    Direction(Function<Integer, Integer> mover) {
        this.mover = mover;
    }

    public int move(int index) {
        return mover.apply(index);
    }

    public boolean isRight() {
        return this.equals(RIGHT);
    }
}
