package nextstep.ladder.domain;

import java.util.Objects;

public class Point {
    private static final int LEFT = -1;
    private static final int RIGHT = 1;

    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public int move() {
        if (direction.isLeft()) {
            return index + LEFT;
        }

        if (direction.isRight()) {
            return index + RIGHT;
        }

        return index;
    }
    public boolean rightLineExists() {
        return direction.isRight();
    }

    public Point next(boolean right) {
        return new Point(index + RIGHT, direction.next(right));
    }

    public Point last() {
        return new Point(index + RIGHT, direction.last());
    }

    public static Point first(Boolean right) {
        return new Point(0, Direction.first(right));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return index == point.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }
}
