package nextstep.ladder.domain;

import nextstep.ladder.exception.DirectionException;

import java.util.function.Function;

public enum Direction {
    LEFT(Boolean.TRUE, Boolean.FALSE, i -> i - 1),
    RIGHT(Boolean.FALSE, Boolean.TRUE, i -> i + 1),
    STOP(Boolean.FALSE, Boolean.FALSE, i -> i);

    private final boolean left;
    private final boolean right;
    private final Function<Integer, Integer> function;

    Direction(boolean left, boolean right, Function<Integer, Integer> function) {
        this.left = left;
        this.right = right;
        this.function = function;
    }

    public static Direction of(boolean left, boolean right) {
        validateDirection(left, right);
        if (left) {
            return LEFT;
        }
        if (right) {
            return RIGHT;
        }
        return STOP;
    }

    private static void validateDirection(boolean left, boolean right) {
        if (right && left) {
            throw new DirectionException();
        }
    }

    public int move(int index) {
        return function.apply(index);
    }
}
