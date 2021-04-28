package ladder.domain;

import java.util.Objects;

public final class Point {
    private final Direction direction;

    public Point(Direction direction) {
        this.direction = direction;
    }

    private static Direction direction(DirectionDeterminer directionDeterminer) {
        return directionDeterminer.isRight() ? Direction.RIGHT : Direction.NONE;
    }

    public static Point first(DirectionDeterminer directionDeterminer) {
        return new Point(direction(directionDeterminer));
    }

    public Point next(DirectionDeterminer directionDeterminer) {
        if (direction.right()) {
            return new Point(Direction.LEFT);
        }

        return new Point(direction(directionDeterminer));
    }

    public Point last() {
        if (direction.right()) {
            return new Point(Direction.LEFT);
        }

        return new Point(Direction.NONE);
    }

    public boolean right() {
        return direction.right();
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
