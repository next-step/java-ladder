package nextstep.ladder2.domain;

import java.util.Objects;
import nextstep.ladder2.domain.builder.RandomBuilder;

public class Direction {
    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException("방향이 두 개가 존재합니다.");
        }
        this.left = left;
        this.right = right;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isLeft() {
        return left;
    }

    public static Direction of(boolean first, boolean second) {
        return new Direction(first, second);
    }

    public static Direction first(boolean right) {
        return of(false, right);
    }

    public Direction next() {
        if (this.right) {
            return next(false);
        }
        return next(RandomBuilder.random.nextBoolean());
    }

    public Direction last() {
        return of(this.right, false);
    }

    public Direction next(boolean nextRight) {
        return of(this.right, nextRight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Direction direction = (Direction) o;
        return left == direction.left && right == direction.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
