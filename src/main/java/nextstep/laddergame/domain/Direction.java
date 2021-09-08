package nextstep.laddergame.domain;

import java.util.function.Function;

public enum Direction {
    LEFT(position -> position + 1),
    RIGHT(position -> position - 1);

    private final Function<Integer, Integer> mover;

    Direction(Function<Integer, Integer> mover) {
        this.mover = mover;
    }

    public int move(int position) {
        return mover.apply(position);
    }

}
