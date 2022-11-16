package laddergame.domain;

import laddergame.exception.ErrorCode;
import laddergame.exception.LadderGameException;

import java.util.Objects;

public class Direction {
    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        validateAllTrue(left, right);
        this.left = left;
        this.right = right;
    }

    private void validateAllTrue(boolean left, boolean right) {
        if (left && right) {
            throw new LadderGameException(ErrorCode.LADDER_LINE_EXIT_CONTINOUSLY);
        }
    }

    public Direction next(boolean next) {
        if (this.right) {
            return new Direction(true, false);
        }
        return new Direction(false, next);
    }

    public static Direction first(boolean right) {
        return new Direction(false, right);
    }

    public Direction last() {
        return new Direction(this.right, false);
    }

    public int move() {
        if (left) {
            return -1;
        }
        if (right) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Direction)) return false;
        Direction direction = (Direction) o;
        return left == direction.left && right == direction.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
