package nextstep.ladder.domain;

import nextstep.ladder.strategy.ConnectStrategy;
import nextstep.ladder.strategy.RandomConnectStrategy;

import java.util.Objects;

public class Direction {
    private static final String CHECK_CONTIONUOUS = "가로 라인이 겹치는 지 확인해주세요.";
    private static final int MOVE_LEFT = -1;
    private static final int MOVE_RIGHT = 1;
    private static final int STAY = 0;

    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        validateContinuous(left, right);
        this.left = left;
        this.right = right;
    }

    private void validateContinuous(boolean left, boolean right) {
        if (left & right) {
            throw new IllegalArgumentException(CHECK_CONTIONUOUS);
        }
    }

    public static Direction first(ConnectStrategy connectStrategy) {
        if (connectStrategy.isConnectable()) {
            return new Direction(false, true);
        }

        return new Direction(false, false);
    }

    public Direction next() {
        if (right) {
            return next(() -> false);
        }

        return next(new RandomConnectStrategy());
    }

    public Direction next(ConnectStrategy connectStrategy) {
        if (connectStrategy.isConnectable()) {
            return new Direction(right, true);
        }

        return new Direction(right, false);
    }

    public Direction last() {
        return new Direction(right, false);
    }

    public boolean hasAnyDirection() {
        return left || right;
    }

    public boolean hasRightDirection() {
        return right;
    }

    public int move() {
        if (left) {
            return MOVE_LEFT;
        }

        if (right) {
            return MOVE_RIGHT;
        }

        return STAY;
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
