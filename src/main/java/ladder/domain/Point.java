package ladder.domain;

import ladder.strategy.MovableStrategy;

public class Point {
    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point first(Boolean right) {
        return new Point(0, Direction.first(right));
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

    public Point next(MovableStrategy movableStrategy) {
        return new Point(index + 1, direction.next(movableStrategy));
    }

    public Point next(Boolean right) {
        return new Point(index + 1, direction.next(right));
    }

    public Point last() {
        return new Point(index + 1, direction.last());
    }

    @Override
    public String toString() {
        return "Point{" +
            "index=" + index +
            ", direction=" + direction +
            '}';
    }
}
