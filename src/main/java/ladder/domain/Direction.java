package ladder.domain;

import java.util.Objects;

public class Direction {
    private static final String LINE_ERROR_MESSAGE = "error : 줄은 연속으로 있을수 없습니다.";
    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        checkLine(left, right);
        this.left = left;
        this.right = right;
    }

    private void checkLine(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException(LINE_ERROR_MESSAGE);
        }
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

    public Direction next() {
        if (this.right) {
            return next(false);
        }
        return next(generatePoint());
    }

    private boolean generatePoint() {
        return LineRandom.random();
    }

    public static Direction of(boolean first, boolean second) {
        return new Direction(first, second);
    }

    public static Direction first(boolean right) {
        return of(false, right);
    }

    public Direction last() {
        return of(this.right, false);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction pair = (Direction) o;
        return left == pair.left &&
                right == pair.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    @Override
    public String toString() {
        return "Direction{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
