package ladder.domain;

import java.util.Objects;

import static java.lang.Boolean.FALSE;

public class Direction {
    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public static Direction first(boolean right) {
        return new Direction(FALSE, right);
    }

    public Direction last() {
        return new Direction(this.right, FALSE);
    }

    public Direction next(boolean nextRight) {
        return new Direction(this.right, nextRight);
    }

    public Direction next(PointGenerationStrategy strategy) {
        if (this.right) {
            return next(FALSE);
        }
        return next(strategy.generate());
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Direction)) return false;
        Direction direction = (Direction) o;
        return left == direction.left &&
                right == direction.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
