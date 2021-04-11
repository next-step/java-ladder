package ladder;

import java.util.Objects;

public class Direction {
    public static Direction LEFT = Direction.of("LEFT");
    public static Direction RIGHT = Direction.of("RIGHT");
    public static Direction NO_DIRECTION = Direction.of("");

    private final String direction;

    private Direction(String direction) {
        this.direction = direction;
    }

    public static Direction of(String direction) {
        return new Direction(direction);
    }

    public String getDirection() {
        return direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction1 = (Direction) o;
        return Objects.equals(direction, direction1.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction);
    }

    @Override
    public String toString() {
        return "Direction{" +
                "direction='" + direction + '\'' +
                '}';
    }
}
