package nextstep.ladder.domain;

import java.util.Objects;
import java.util.Random;

public class Point {
    public static final Random RANDOM = new Random();

    private final Direction direction;
    private final int index;

    private Point(Direction direction, int index) {
        this.direction = direction;
        this.index = index;
    }

    public static Point of(Direction direction, int index) {
        return new Point(direction, index);
    }

    public static Point first() {
        return Point.of(Direction.first(), 0);
    }

    public static Point first(boolean value) {
        return Point.of(Direction.first(value), 0);
    }

    public Point next(int index) {
        return Point.of(direction.next(), index);
    }

    public Point last(int index) {
        return Point.of(this.direction.last(), index);
    }

    public int move() {
        if (this.direction.isRight()) {
            return index + 1;
        }
        if (this.direction.isLeft()) {
            return index - 1;
        }
        return index;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(direction, point.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction);
    }
}
