package ladder.domain;

import java.util.Objects;
import java.util.Random;

public final class Point {
    private static final Random random = new Random();

    private final Direction direction;

    public Point(Direction direction) {
        this.direction = direction;
    }

    private static Point randomPoint() {
        return random.nextInt(10) > 5 ? new Point(Direction.RIGHT) : new Point(Direction.NONE);
    }

    public static Point first() {
        return randomPoint();
    }

    public Point next() {
        if (direction.right()) {
            return new Point(Direction.LEFT);
        }

        return randomPoint();
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
