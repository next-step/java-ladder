package nextstep.laddergame.model;

import java.util.Objects;

public class Point {

    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point first(boolean right) {
        return of(0, Direction.first(right));
    }

    private static Point of(int index, Direction direction) {
        return new Point(index, direction);
    }

    public Point last() {
        return of(index + 1, direction.last());
    }

    public Point next(boolean right) {
        return of(index + 1, direction.next(right));
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return index == point.index && Objects.equals(direction, point.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, direction);
    }
}
