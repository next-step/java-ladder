package step3.domain;

import step3.hint.Direction;

public class Point {
    private final int index;
    private final Direction direction;

    Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public Point next() {
        return new Point(index + 1, direction.next());
    }

    public Point next(boolean current) {
        return new Point(index + 1, direction.next(current));
    }

    public Point last() {
        return new Point(index + 1, direction.last());
    }

    public static Point first(Boolean current) {
        return new Point(0, Direction.first(current));
    }

    public int move() {
        if (direction.isRight()) {
            return index + 1;
        }

        if (direction.isLeft()) {
            return index - 1;
        }
        return this.index;
    }

    @Override
    public String toString() {
        return "Point{" +
                "index=" + index +
                ", direction=" + direction +
                '}';
    }
}
