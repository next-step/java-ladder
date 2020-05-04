package ladder.domain;

import java.util.Objects;

import static java.lang.Boolean.FALSE;

public class Direction {
    private static final String DIRECTION_INVALID_EXCEPTION_MESSAGE = "사다리 타기가 정상적으로 동작하려면 겹치지 않아야 합니다!";

    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException(DIRECTION_INVALID_EXCEPTION_MESSAGE);
        }

        this.left = left;
        this.right = right;
    }

    public static Direction first(boolean right) {
        return of(FALSE, right);
    }

    public static Direction of(boolean left, boolean right) {
        return new Direction(left, right);
    }

    public Direction next() {
        if (this.right) {
            return next(FALSE);
        }

        return of(false, DirectionGenerator.generateDirection());
    }

    public Direction next(boolean nextRight) {
        return of(this.right, nextRight);
    }

    public boolean isLeft() {
        return this.left;
    }

    public boolean isRight() {
        return this.right;
    }

    public Direction last() {
        return of(this.right, FALSE);
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
