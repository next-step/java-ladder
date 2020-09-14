package ladder.domain;

import java.util.Objects;

public class Point {
    private final int index;
    private final Direction direction;

    private Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point first(boolean current) {
        return new Point(0, new Direction(false, current));
    }

    public Point next(boolean current) {
        if (direction.isCurrent() == current) {
            return new Point(index + 1, new Direction(direction.isCurrent(), !current));
        }
        return new Point(index + 1, new Direction(direction.isCurrent(), current));
    }

    public Point last() {
        return new Point(index + 1, new Direction(direction.isCurrent(), false));
    }

    int move() {
       return index + direction.move();
    }

    public boolean isLeft() {
        return direction.isLeft();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return index == point.index &&
                Objects.equals(direction, point.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, direction);
    }
}
