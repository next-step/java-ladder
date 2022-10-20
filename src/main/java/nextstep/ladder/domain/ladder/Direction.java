package nextstep.ladder.domain.ladder;

import java.util.Objects;

public class Direction {
    private static final String DIRECTION_EXCEPTION_MESSAGE = "두 방향 모두 열릴 수 없습니다.";

    private final boolean left;
    private final boolean right;

    public Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException(DIRECTION_EXCEPTION_MESSAGE);
        }

        this.left = left;
        this.right = right;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
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
        return (left && direction.left) || (right && direction.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
