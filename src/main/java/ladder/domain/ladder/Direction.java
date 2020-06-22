package ladder.domain.ladder;

import ladder.domain.strategy.LineStrategy;

import java.util.Objects;

import static java.lang.Boolean.FALSE;

public class Direction {

    public static final int DISTANCE = 1;

    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public Direction next(boolean nextRight) {
        return of(this.right, nextRight);
    }

    public Direction next(LineStrategy lineStrategy) {
        if (this.right) {
            return next(FALSE);
        }
        return next(lineStrategy.hasLine());
    }

    public static Direction of(boolean first, boolean second) {
        return new Direction(first, second);
    }

    public static Direction first(boolean right) {
        return of(FALSE, right);
    }

    public Direction last() {
        return of(this.right, FALSE);
    }

    public int getNextIndex(int index) {
        if (left) {
            return index - DISTANCE;
        }
        if (right) {
            return index + DISTANCE;
        }
        return index;
    }

    public boolean isRight() {
        return right;
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
