package ladder;

import java.util.Objects;

public class Point {
    private final int index;
    private final Direction direction;

    private Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point of(int index, Direction direction) {
        return new Point(index, direction);
    }

    public static Point first(boolean right) {
        return new Point(0, Direction.first(right));
    }

    public Point next(PointConnectStrategy pointConnectStrategy) {
        return new Point(index + 1, direction.next(pointConnectStrategy));
    }

    public Point next(boolean right) {
        return new Point(index + 1, direction.next(right));
    }

    public Point last() {
        return new Point(index + 1, direction.last());
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

    public boolean isleftConnected() {
        return direction.isLeft();
    }

    public boolean isRightConnected() {
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
