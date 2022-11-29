package ladder.domain;

import ladder.strategy.LineCreateStrategy;

import java.util.Objects;

import static java.lang.Boolean.FALSE;

public class Direction {
    private static final String LINE_CAN_NOT_OVERLAP_MESSAGE = "가로라인이 겹칠 수 없습니다.";
    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException(LINE_CAN_NOT_OVERLAP_MESSAGE);
        }
        this.left = left;
        this.right = right;
    }

    public boolean isRight() {
        return this.right;
    }

    public boolean isLeft() {
        return this.left;
    }

    public Direction next(boolean nextRight) {
        return of(this.right, nextRight);
    }

    public Direction next(LineCreateStrategy lineCreateStrategy) {
        if (this.right) {
            return next(FALSE);
        }
        return next(lineCreateStrategy.create());
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
