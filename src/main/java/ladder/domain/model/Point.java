package ladder.domain.model;

import ladder.common.RandomStrategy;

import java.util.Objects;

public class Point {
    private Index index;
    private Direction direction;

    private Point(Index index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    private static Point of(Index index, Direction direction) {
        return new Point(index, direction);
    }

    public static Point ofStart(RandomStrategy randomStrategy) {
        return Point.of(Index.ofStart(), Direction.ofStart(randomStrategy));
    }

    public Point ofEnd() {
        return Point.of(index.next(), direction.ofEnd());
    }

    public Point next(RandomStrategy randomStrategy) {
        return of(index.next(), direction.next(randomStrategy));
    }

    public boolean isLeft() {
        return direction.isLeft();
    }

    public boolean isRight() {
        return direction.isRight();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(index, point.index) &&
                Objects.equals(direction, point.direction);
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
