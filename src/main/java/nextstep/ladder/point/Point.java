package nextstep.ladder.point;

import java.util.Objects;

public class Point {

    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point first(boolean movableRight) {
        return new Point(0, Direction.first(movableRight));
    }

    public Point last() {
        return new Point(this.index + 1, direction.last());
    }

    public int move() {
        return this.index + direction.move();
    }

    public boolean isMovableRight() {
        return direction.isMovableRight();
    }

    public boolean isMovableLeft() {
        return direction.isMovableLeft();
    }

    public Point next(boolean next) {
        return new Point(this.index + 1, direction.next(next));
    }

    public Point next() {
        return new Point(this.index + 1, direction.next());
    }

    @Override
    public String toString() {
        return "Point{" +
                "index=" + index +
                ", direction=" + direction +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return index == point.index && Objects.equals(direction, point.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, direction);
    }
}
