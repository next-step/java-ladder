package nextstep.ladder.domain;

import java.util.Objects;

public class Point {
    private final Index index;
    private final Direction direction;

    private Point(Index index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point first(Boolean right) {
        return new Point(Index.HEAD, Direction.first(right));
    }

    public Index move() {
        return index.jump(direction.diff());
    }

    public Point next(Boolean right) {
        return new Point(index.next(), direction.next(right));
    }

    public Point last() {
        return new Point(index.next(), direction.last());
    }

    public boolean isRight() {
        return direction == Direction.RIGHT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(index, point.index) && direction == point.direction;
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