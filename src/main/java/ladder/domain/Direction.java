package ladder.domain;

import java.util.Objects;

public class Direction {
    private final boolean left;
    private final boolean current;

    Direction(boolean left, boolean current) {
        if (left && current) {
            throw new IllegalArgumentException("유효하지 않은 값 입니다.");
        }
        this.left = left;
        this.current = current;
    }

    int move() {
        if (left) {
            return -1;
        }
        if (current) {
            return 1;
        }
        return 0;
    }

    boolean isLeft() {
        return left;
    }

    boolean isCurrent() {
        return current;
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
}
