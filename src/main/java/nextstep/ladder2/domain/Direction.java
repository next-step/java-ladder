package nextstep.ladder2.domain;

import nextstep.ladder.application.CreatePointStrategy;
import nextstep.ladder.application.RandomCreatePoint;

import java.util.Objects;

public class Direction {

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
        return new Direction(false, right);
    }

    private void validateDirection(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("양쪽으로 사다리를 연결 할 수 없습니다.");
        }
    }

    public Direction next(boolean rightOfNext) {
        return new Direction(right, rightOfNext);
    }

    public Direction next(CreatePointStrategy createPointStrategy) {
        if (right) {
            return new Direction(right, false);
        }
        return new Direction(right, createPointStrategy.isDraw());
    }

    public Direction last() {
        return new Direction(right, false);
    }

    public boolean isRight() {
        return right;
    }

    public boolean isLeft() {
        return left;
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
