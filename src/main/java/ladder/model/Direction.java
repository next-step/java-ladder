package ladder.model;

import java.util.Objects;

public class Direction {

    private static final String LINE_OVERLAPPED_MSG = "라인은 겹치면 안됩니다.";

    private final boolean left;
    private final boolean right;

    private Direction(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public static Direction of(boolean left, boolean right) {
        validateDirection(left, right);
        return new Direction(left, right);
    }

    private static void validateDirection(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException(LINE_OVERLAPPED_MSG);
        }
    }

    public static Direction first(boolean right){
        return of(false, right);
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

    public boolean isLeft() {
        return this.left;
    }

    public Direction next(boolean right) {
        return of(this.right,right);
    }

    public Direction last() {
        return of(this.right, false);
    }
}
