package step2.domain;

import java.util.function.Function;

public enum Direction {
    LEFT((position) -> position - 1),
    RIGHT((position) -> position + 1),
    NONE((position) -> position);

    private final Function<Integer, Integer> moveResult;

    Direction(Function<Integer, Integer> moveResult) {
        this.moveResult = moveResult;
    }

    public static Direction findBy(boolean left, boolean right) {
        if (left) {
            return LEFT;
        }
        if (right) {
            return RIGHT;
        }
        return NONE;
    }

    public int move(int position) {
        return moveResult.apply(position);
    }
}
