package nextstep.ladder.domain.ladder;

import nextstep.ladder.util.ConnectStrategy;

import java.util.Objects;

public class Direction {
    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        validateDirection(left, right);
        this.left = left;
        this.right = right;
    }

    private void validateDirection(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("[ERROR] 한 방향으로만 연결될 수 있습니다.");
        }
    }

    public static Direction of(boolean left, boolean right) {
        return new Direction(left, right);
    }

    public static Direction first(ConnectStrategy connectStrategy) {
        return new Direction(false, connectStrategy.isConnected());
    }

    public Direction next(ConnectStrategy connectStrategy) {
        if (right) {
            return new Direction(true, false);
        }
        return new Direction(false, connectStrategy.isConnected());
    }

    public Direction last() {
        return new Direction(right, false);
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
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return left == direction.left && right == direction.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
