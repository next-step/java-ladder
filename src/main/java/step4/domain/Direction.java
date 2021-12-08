package step4.domain;

import java.util.Objects;

public class Direction {
    private final boolean left;
    private final boolean current;

    private Direction(boolean left, boolean current) {
        validate(left, current);
        this.left = left;
        this.current = current;
    }

    public static Direction of(boolean left, boolean current) {
        return new Direction(left, current);
    }

    public static Direction start(boolean current) {
        return of(false, current);
    }

    public Direction next(boolean current) {
        if (connected(this.current, current)) {
            return of(this.current, Boolean.FALSE);
        }
        return of(this.current, current);
    }

    public Direction last() {
        return of(this.current, false);
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return current;
    }

    public void validate(boolean left, boolean current) {
        if (connected(left, current)) {
            throw new IllegalArgumentException("두 방향은 연결될 수 없습니다.");
        }
    }

    private boolean connected(boolean left, boolean current) {
        return Boolean.logicalAnd(left, current);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction = (Direction) o;
        return left == direction.left &&
                current == direction.current;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, current);
    }

    @Override
    public String toString() {
        return "Direction{" +
                "left=" + left +
                ", current=" + current +
                '}';
    }
}
