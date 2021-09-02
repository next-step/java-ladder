package ladder.domain;

import java.util.Objects;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Direction {

    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalStateException("사다리는 양쪽으로 이동할 수 없습니다");
        }
        this.left = left;
        this.right = right;
    }

    public static Direction start(Movable movable) {
        return new Direction(FALSE, movable.move());
    }

    public static Direction create(boolean left, boolean right) {
        return new Direction(left, right);
    }

    public Direction next() {
        if (this.right) {
            return new Direction(TRUE, FALSE);
        }
        return new Direction(FALSE, randomMovable());
    }

    public Direction end() {
        return new Direction(this.right, FALSE);
    }

    public boolean isLeft() {
        return this.left;
    }

    public boolean isRight() {
        return this.right;
    }

    private boolean randomMovable() {
        return Math.random() < 0.5;
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
