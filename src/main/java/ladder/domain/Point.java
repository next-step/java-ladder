package ladder.domain;

import java.util.Objects;

public class Point {
    private static final int VARIATION_UNIT = 1;

    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public int next() {
        return right(index);
    }

    public boolean hasRightDirection() {
        return direction.hasRightDirection();
    }

    public boolean hasLeftDirection() {
        return direction.hasLeftDirection();
    }

    public boolean hasDirection() {
        return direction.hasDirection();
    }

    public int move() {
        if (direction.hasRightDirection()) {
            return right(index);
        }
        if (direction.hasLeftDirection()) {
            return left(index);
        }
        return index;
    }

    private int right(int index) {
        return index + VARIATION_UNIT;
    }

    private int left(int index) {
        return index - VARIATION_UNIT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return index == point.index && Objects.equals(direction, point.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, direction);
    }
}
