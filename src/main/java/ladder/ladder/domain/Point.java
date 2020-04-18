package ladder.ladder.domain;

import java.util.Objects;

public class Point {
    private final Index index;
    private final Direction direction;

    private Point(Index index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point of(int index, Direction direction) {
        return new Point(Index.of(index), direction);
    }

    public static Point generateFirst(boolean right) {
        return new Point(Index.init(), Direction.generateFirst(right));
    }

    public Index move() {
        if (direction.isRight()) {
            return index.increase();
        }
        if (direction.isLeft()) {
            return index.decrease();
        }
        return this.index;
    }

    public Point generateNext(LinkStrategy linkStrategy) {
        return new Point(index.increase(), direction.generateNext(linkStrategy.get()));
    }

    public Point generateNext(Boolean right) {
        return new Point(index.increase(), direction.generateNext(right));
    }

    public Point generateLast() {
        return new Point(index.increase(), direction.generateLast());
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
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
