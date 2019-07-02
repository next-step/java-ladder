package ladder.domain;

import java.util.Objects;

public class Point {

    private static final int FIRST = 0;
    private int position;
    private Direction direction;

    private Point(int position, Direction direction) {

        this.position = position;
        this.direction = direction;
    }

    public static Point of(int position, Direction direction) {
        return new Point(position, direction);
    }

    public static Point first(boolean generateValue) {

        return Point.of(FIRST, Direction.first(generateValue));
    }

    public static Point middle(int position, Direction before, boolean generateValue) {

        return Point.of(position, Direction.middle(before, generateValue));
    }

    public static Point last(int lastPosition, Direction before) {

        return Point.of(lastPosition, Direction.last(before));
    }

    public int move() {

        if (direction == Direction.LEFT) {
            return position - 1;
        }

        if (direction == Direction.RIGHT) {
            return position + 1;
        }

        return position;
    }

    public Direction getDirection() {

        return direction;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return position == point.position &&
                direction == point.direction;
    }

    @Override
    public int hashCode() {

        return Objects.hash(position, direction);
    }
}
