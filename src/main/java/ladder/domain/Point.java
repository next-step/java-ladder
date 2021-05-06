package ladder.domain;

import java.util.Objects;

public final class Point {
    private final Direction direction;

    public Point(Direction direction) {
        this.direction = direction;
    }


    public static Point first(DirectionDeterminer directionDeterminer) {
        return new Point(Direction.first(directionDeterminer));
    }

    public Point next(DirectionDeterminer directionDeterminer) {
        return new Point(direction.next(directionDeterminer));
    }

    public Point last() {
        return new Point(direction.last());
    }

    public boolean right() {
        return direction == Direction.RIGHT;
    }

    public boolean left() {
        return direction == Direction.LEFT;
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
