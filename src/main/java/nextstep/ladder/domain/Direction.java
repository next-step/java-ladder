package nextstep.ladder.domain;

import java.util.Objects;

import static java.lang.Boolean.FALSE;
import static nextstep.ladder.domain.PointGenerator.generatePoint;

public class Direction {

    private static final String INVALID_DIRECTION_MESSAGE = "양쪽 모두 연결 될 수 없습니다";

    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException(INVALID_DIRECTION_MESSAGE);
        }
        this.left = left;
        this.right = right;
    }

    public static Direction of(boolean left, boolean right) {
        return new Direction(left, right);
    }

    public static Direction first(boolean right) {
        return new Direction(FALSE, right);
    }

    public Direction next() {
        if (this.right) {
            return next(FALSE);
        }
        return next(generatePoint());
    }

    public Direction next(boolean nextRight) {
        return of(this.right, nextRight);
    }

    public boolean isRight() {
        return this.right;
    }

    public boolean isLeft() {
        return this.left;
    }

    public Direction last() {
        return of(this.right, FALSE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return left == direction.left && right == direction.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
