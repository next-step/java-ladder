package ladder.domain;

import java.util.function.IntFunction;

public enum Direction {
    RIGHT((position -> position + 1)),
    LEFT((position -> position - 1)),
    STAY(position -> position);

    private final IntFunction<Integer> move;
    Direction(IntFunction<Integer> move) {
        this.move = move;
    }

    public int move(int startPoint) {
        return this.move.apply(startPoint);
    }
}
