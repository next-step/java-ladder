package ladderinterface.concrete;

import java.util.Objects;

public class Point {
    private final int position;
    private final Direction direction;

    private Point(int position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public static Point of(int position, Direction direction) {
        return new Point(position, direction);
    }

    public static Point first(boolean current) {
        return new Point(0, Direction.first(current));
    }

    public Point last() {
        return new Point(position + 1, direction.last());
    }

    public Point nextRandom() {
        return new Point(position + 1, direction.nextRandom());
    }

    public Point next(boolean current) {
        return new Point(position + 1 , direction.next(current));
    }

    public int move() {
        if (direction.isLeft()) {
            return position - 1;
        }

        if (direction.isRight()) {
            return position + 1;
        }

        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return position == point.position && Objects.equals(direction, point.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, direction);
    }
}
