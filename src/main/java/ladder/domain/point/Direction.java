package ladder.domain.point;

import ladder.domain.strategy.PointStrategy;

import java.util.Objects;

public class Direction {
    private final boolean left;
    private final boolean current;

    private Direction(boolean left, boolean current) {
        this.left = left;
        this.current = current;
    }

    public static Direction first(PointStrategy pointStrategy) {
        return new Direction(false, pointStrategy.next());
    }

    public Direction next(PointStrategy pointStrategy) {
        if (this.current) {
            return next(false);
        }

        return next(pointStrategy.next());
    }

    private Direction next(boolean next) {
        return new Direction(current, next);
    }

    public Direction last() {
        return new Direction(this.current, false);
    }

    public int move() {
        if (this.left) {
            return -1;
        }

        if (this.current) {
            return +1;
        }

        return 0;
    }

    public boolean isLeft() {
        return left;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return left == direction.left &&
                current == direction.current;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, current);
    }
}
