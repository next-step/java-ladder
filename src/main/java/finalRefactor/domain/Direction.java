package finalRefactor.domain;

import java.util.Objects;
import java.util.Random;

public class Direction {
    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        validation(left, right);
        this.left = left;
        this.right = right;
    }

    public static Direction of(boolean left, boolean right) {
        return new Direction(left, right);
    }

    private void validation(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("같은 라인이 생성될 수 없습니다.");
        }
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public static Direction first(boolean right) {
        return new Direction(false, right);
    }

    public Direction next() {
        if (right) {
            return next(false);
        }

        return next(generatePoint());
    }

    public Direction next(boolean nextRight) {
        return new Direction(this.right, nextRight);
    }

    public Direction last() {
        return new Direction(this.right, false);
    }
    private boolean generatePoint() {
        Random random = new Random();
        return random.nextBoolean();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction location = (Direction) o;
        return left == location.left && right == location.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    @Override
    public String toString() {
        return "[" + left + ", " + right + "]";
    }

}
