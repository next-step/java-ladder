package nextstep.laddergame.model;

import nextstep.laddergame.exception.InvalidDirectionException;

public class Direction {

    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        if (left && right) {
            throw new InvalidDirectionException("left and right are must not be both true");
        }
        this.left = left;
        this.right = right;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isLeft() {
        return left;
    }

    public static Direction first(boolean right) {
        return of(false, right);
    }

    private static Direction of(boolean left, boolean right) {
        return new Direction(left, right);
    }

    public Direction last() {
        return of(right, false);
    }

    public Direction next(boolean nextRight) {
        if (right) {
            return of(right, false);
        }
        return of(right, nextRight);
    }
}
