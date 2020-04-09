package nextstep.ladder.domain.line;

import nextstep.ladder.controller.RandomDirectionSelector;

public class Point {
    private final int index;
    private final Direction direction;
    private final DirectionSelector directionSelector;

    public Point(int index, Direction direction) {
        this(index, direction, new RandomDirectionSelector());
    }

    public Point(int index, Direction direction,
                 DirectionSelector directionSelector) {
        this.index = index;
        this.direction = direction;
        this.directionSelector = directionSelector;
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

    public Point next() {
        return new Point(index + 1, direction.next(directionSelector));
    }

    public Point next(Boolean right) {
        return new Point(index + 1, direction.next(right));
    }

    public Point last() {
        return new Point(index + 1, direction.last());
    }

    public boolean hasRightDirection() {
        return direction.isRight();
    }

    public static Point first() {
        return first(new RandomDirectionSelector());
    }

    public static Point first(DirectionSelector directionSelector) {
        return new Point(0, Direction.first(directionSelector));
    }

    @Override
    public String toString() {
        return "Point{" +
                "index=" + index +
                ", direction=" + direction +
                '}';
    }
}