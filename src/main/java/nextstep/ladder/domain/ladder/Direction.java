package nextstep.ladder.domain.ladder;

import java.util.Objects;

public class Direction {
    private final boolean left;
    private final boolean right;

    public static Direction first(final DirectionStrategy directionStrategy) {
        return first(directionStrategy.generate());
    }

    public static Direction first(final boolean right) {
        return of(false, right);
    }

    public static Direction of(final boolean left, final boolean right) {
        return new Direction(left, right);
    }

    private Direction(final boolean left, final boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("Direction 은 양쪽 방향을 가질 수 없습니다.");
        }

        this.left = left;
        this.right = right;
    }

    public Direction next(final DirectionStrategy directionStrategy) {
        return next(directionStrategy.generate());
    }

    public Direction next(final boolean nextRight) {
        return this.right ? of(true, false) : of(false, nextRight);
    }

    public Direction last() {
        return of(this.right, false);
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Direction)) return false;
        final Direction direction = (Direction) o;
        return left == direction.left &&
                right == direction.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    @Override
    public String toString() {
        return "Direction{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
