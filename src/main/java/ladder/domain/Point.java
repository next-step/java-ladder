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

    private Point newLinkPoint(Direction direction) {
        return new Point(index + 1, direction);
    }

    public boolean checkIndex(int index) {
        return this.index == index;
    }
}
