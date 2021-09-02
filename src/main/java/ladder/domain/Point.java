package ladder.domain;

import java.util.Objects;

public class Point {

    private final int index;

    private final Direction direction;

    private Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point start(Direction direction) {
        return new Point(0, direction);
    }

    public static Point create(int index, Direction direction) {
        return new Point(index, direction);
    }

    public Point next() {
        return new Point(index + 1, direction.next());
    }

    public Point end() {
        return new Point(index + 1, direction.end());
    }

    public int move() {
        if (direction.isLeft()) {
            return index - 1;
        }

        if (direction.isRight()) {
            return index + 1;
        }

        return index;
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
