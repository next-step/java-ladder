package ladder.domain;

import java.util.Objects;

public final class Point {
    private static final int FIRST_INDEX = 0;

    private final int index;
    private final Direction direction;

    public Point(final int index, final Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point first(final DirectionDeterminer directionDeterminer) {
        return new Point(FIRST_INDEX, Direction.first(directionDeterminer));
    }

    public Point next(final DirectionDeterminer directionDeterminer) {
        return new Point(index + 1, direction.next(directionDeterminer));
    }

    public Point last() {
        return new Point(index + 1, direction.last());
    }

    public int move() {
        if (direction == Direction.RIGHT) {
            return index + 1;
        }

        if (direction == Direction.LEFT) {
            return index - 1;
        }

        return index;
    }

    public boolean right() {
        return direction == Direction.RIGHT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return direction == point.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction);
    }

}
