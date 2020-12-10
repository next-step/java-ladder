package domain;

import java.util.Objects;
import static domain.RandomDirectionGenerator.generate;

public class Direction {
    private final boolean left;
    private final boolean right;

    private Direction(final boolean left, final boolean right) {
        this.left = left;
        this.right = right;
    }

    public static Direction of(final boolean left, final boolean right) {
        if( left && right) {
            throw new IllegalStateException();
        }
        return new Direction(left, right);
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public static Direction first(final boolean right) {
        return Direction.of(false, right);
    }

    public Direction last() {
        return Direction.of(this.right, false);
    }

    public Direction next() {
        if(this.right) {
            return next(false);
        }

        return Direction.of(false, generate());
    }

    public Direction next(final boolean right) {
        return Direction.of(this.right, right);
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
