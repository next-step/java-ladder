package ladder.domain.ladder;

import java.util.Objects;

public class Point {
    private static final int ADD_INDEX = 1;

    private final int index;
    private final Direction direction;

    private Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point first(boolean isRight) {
        return new Point(0, Direction.of(false, isRight));
    }

    public Point next(boolean isRight) {
        return new Point(index + ADD_INDEX, Direction.of(direction.isRight(), isRight));
    }

    public Point last() {
        return new Point(index + ADD_INDEX, Direction.of(direction.isRight(), false));
    }

    int move() {
       return index + direction.move();
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return index == point.index &&
                Objects.equals(direction, point.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, direction);
    }
}
