package ladder.domain;

import ladder.exception.LadderExceptionMessage;

import java.util.Objects;

public class Direction {
    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public static Direction of(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException(LadderExceptionMessage.INVALID_LINE_DIRECTION_INPUT);
        }

        return new Direction(left, right);
    }

    public static Direction getFirst(boolean right) {
        return Direction.of(false, right);
    }

    public static Direction getLast(boolean left) {
        return Direction.of(left, false);
    }

    public boolean isLeft() {
        return this.left;
    }

    public boolean isRight() {
        return this.right;
    }

    public Direction next(boolean right) {
        if (isRight()) {
            return Direction.of(isRight(), false);
        }
        return Direction.of(false, right);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return left == direction.left &&
                right == direction.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
