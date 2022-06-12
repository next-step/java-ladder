package ladder.domain;

import java.util.Objects;

public class Point {
    private boolean point;
    private Point prevPoint;
    private int index;
    private Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point first(boolean right) {
        return new Point(0, Direction.first(right));
    }

    public int move() {
        if (direction.isRight()) {
            return this.index + 1;
        }

        if (direction.isLeft()) {
            return this.index - 1;
        }

        return this.index;
    }

    public Point(boolean point) {
        this.point = point;
    }

    public Point(boolean point, Point prevPoint) {
        this(point);
        this.prevPoint = prevPoint;
    }

    public String drawPoint() {
        if (point) {
            return "-----";
        }
        return "     ";
    }

    public boolean isTrue() {
        return this.point;
    }

    public Point next(boolean right) {
        return new Point(this.index + 1, direction.next(right));
    }

    public Point next() {
        return new Point(index + 1, direction.next());
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
                "point=" + point +
                '}';
    }

}
