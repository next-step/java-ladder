package nextstep.ladder.v2.model;

import java.util.function.Function;

public enum Direction {
    RIGHT(x -> x + 1),
    LEFT(x -> x - 1),
    DOWN(x -> x);

    private Function<Integer, Integer> function;

    Direction(Function<Integer, Integer> function) {
        this.function = function;
    }

    public int getNextPosition(int startPosition) {
        return function.apply(startPosition);
    }

    public static Direction of(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("both previous and current point must not be true");
        }

        if (!left && !right) {
            return DOWN;
        }
        if (!left && right) {
            return RIGHT;
        }
        return LEFT;
    }
}
