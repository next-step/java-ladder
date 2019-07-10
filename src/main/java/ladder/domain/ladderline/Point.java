package ladder.domain.ladderline;

import ladder.common.RandomStrategy;

import java.util.Objects;

public class Point {
    private Index index;
    private Direction direction;

    private Point(Index index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    static Point of(Index index, Direction direction) {
        return new Point(index, direction);
    }

    static Point ofStart(RandomStrategy randomStrategy) {
        return Point.of(Index.ofStart(), Direction.ofStart(randomStrategy));
    }

    Point ofEnd() {
        return Point.of(index.next(), direction.ofEnd());
    }

    Point next(RandomStrategy randomStrategy) {
        return of(index.next(), direction.next(randomStrategy));
    }

    Index current() {
        return index;
    }

    boolean isLeft() {
        return direction.isLeft();
    }

    public boolean isRight() {
        return direction.isRight();
    }

    Index move() {
        if (direction.isRight()) {
            return index.next();
        }

        if (direction.isLeft()) {
            return index.prev();
        }

        return index;
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
