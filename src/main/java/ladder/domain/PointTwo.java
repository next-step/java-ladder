package ladder.domain;

import java.util.Objects;
import java.util.Random;

public final class PointTwo {
    private static final Random random = new Random();

    private final Direction direction;

    public PointTwo(Direction direction) {
        this.direction = direction;
    }

    private static PointTwo randomPoint() {
        return random.nextInt(10) > 5 ? new PointTwo(Direction.RIGHT) : new PointTwo(Direction.NONE);
    }

    public static PointTwo first() {
        return randomPoint();
    }

    public PointTwo next() {
        if (direction.right()) {
            return new PointTwo(Direction.LEFT);
        }

        return randomPoint();
    }

    public PointTwo last() {
        if (direction.right()) {
            return new PointTwo(Direction.LEFT);
        }

        return new PointTwo(Direction.NONE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointTwo pointTwo = (PointTwo) o;
        return direction == pointTwo.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction);
    }
}
