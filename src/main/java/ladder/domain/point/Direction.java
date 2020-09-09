package ladder.domain.point;

import ladder.domain.strategy.PointStrategy;

import java.util.Objects;

import static java.lang.Boolean.FALSE;

public class Direction {
    private static final String NOT_CORRECT_DIRECTION_MESSAGE = "방향이 올바르지 않습니다.";

    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        validateDirection(left, right);
        this.left = left;
        this.right = right;
    }

    public static Direction of(boolean left, boolean right) {
        return new Direction(left, right);
    }

    public static Direction first(boolean right) {
        return of(FALSE, right);
    }

    public Direction last() {
        return of(right, FALSE);
    }

    public Direction next(boolean strategy) {
        return of(right, strategy);
    }

    public Direction next(PointStrategy pointStrategy) {
        if (this.right) {
            return next(FALSE);
        }
        return next(pointStrategy.next());
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    private void validateDirection(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException(NOT_CORRECT_DIRECTION_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction that = (Direction) o;
        return left == that.left &&
                right == that.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
