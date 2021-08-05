package ladder.domain;

import ladder.domain.direction.Direction;

public final class Point {
    private final int index;
    private final Direction direction;

    private Point(final int index, final Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point first() {
        return new Point(0, Direction.first());
    }

    public Point next() {
        return newLinkPoint(direction.next());
    }

    public Point last() {
        return newLinkPoint(direction.last());
    }

    private Point newLinkPoint(final Direction direction) {
        return new Point(index + 1, direction);
    }

    public int move(final int index) {
        if (direction.isLeft()) {
            return index - 1;
        }
        if (direction.isRight()) {
            return index + 1;
        }
        return index;
    }

    public boolean checkIndex(final int index) {
        return this.index == index;
    }
}
