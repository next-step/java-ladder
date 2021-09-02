package nextstep.ladder.domain;

import java.util.Objects;

import static java.lang.Boolean.FALSE;
import static nextstep.ladder.domain.LadderPointGenerator.generatePoint;

public class Direction {
    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        validateDirection(left, right);
        this.left = left;
        this.right = right;
    }

    private void validateDirection(final boolean left, final boolean right) {
        if (left && right) {
            throw new IllegalStateException();
        }
    }

    public boolean isRight() {
        return right;
    }

    public boolean isLeft() {
        return left;
    }

    public Direction next(boolean nextRight) {
        return of(right, nextRight);
    }

    public Direction next() {
        return right
                ? next(FALSE)
                : next(generatePoint());
    }

    public static Direction of(boolean first, boolean second) {
        return new Direction(first, second);
    }

    public static Direction first(boolean right) {
        return of(FALSE, right);
    }

    public Direction last() {
        return of(right, FALSE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction pair = (Direction) o;
        return left == pair.left &&
                right == pair.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

}
