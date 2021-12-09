package ladder.domain;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Point {

    static ThreadLocalRandom random = ThreadLocalRandom.current();

    private final Position position;
    private final Direction direction;

    public Point(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public static Point createFirstPoint() {
        return new Point(new Position(), Direction.createRandomDirection(() -> random.nextBoolean()));
    }

    public static Point createPoint(int index) {
        return new Point(new Position(index).move(), new Direction(true, false));
    }

    public static Point createRandomPoint(int index) {
        return new Point(new Position(index).move(), Direction.createRandomDirection(() -> random.nextBoolean()));
    }

    public boolean isRight() {
        return direction.isRight();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(position, point.position) && Objects.equals(direction, point.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, direction);
    }

    @Override
    public String toString() {
        return "position=" + position +
                        " " + direction;
    }

}

