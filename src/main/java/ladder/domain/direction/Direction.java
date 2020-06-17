package ladder.domain.direction;

import java.util.Objects;

public class Direction {

    private final boolean left;
    private final boolean right;

    private Direction(boolean isLeft, boolean isRight) {
        this.left = isLeft;
        this.right = isRight;
    }

    public static Direction of(boolean isLeft, boolean isRight) {
        if (isLeft && isRight) {
            throw new IllegalArgumentException("좌, 우 중 한 쪽으로만 향할 수 있습니다");
        }

        return new Direction(isLeft, isRight);
    }

    public static Direction first(boolean isRight) {
        return Direction.of(false, isRight);
    }

    public static Direction last(boolean isLeft) {
        return Direction.of(isLeft, false);
    }

    public Direction next(boolean isNextRight) {
        if (this.right) {
            return Direction.of(true, false);
        }

        return Direction.of(false, isNextRight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Direction direction = (Direction) o;
        return left == direction.left &&
                right == direction.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
