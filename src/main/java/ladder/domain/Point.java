package ladder.domain;

import ladder.strategy.PointStrategy;

import java.util.Objects;

public class Point {
    private final int index;
    private final Direction direction;

    private Point(final int index, final Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point from(final int index, final Direction direction) {
        return new Point(index, direction);
    }

    public int move() {
        if (direction.isRight()) {
            return index + 1;
        }

        if (direction.isLeft()) {
            return index - 1;
        }

        return this.index;
    }

    public Point next(PointStrategy pointStrategy) {
        return new Point(index + 1, direction.next(pointStrategy));
    }

    public Point last() {
        return new Point(index + 1, direction.last());
    }

    public static Point first(final Boolean right) {
        return new Point(0, Direction.first(right));
    }

    public boolean isRight() {
        return direction.isRight();
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

    @Override
    public String toString() {
        return "Point{" +
                "index=" + index +
                ", direction=" + direction +
                '}';
    }
}
