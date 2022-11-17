package ladder.model;

import java.util.Objects;

public class Point {

    private final Position position;
    private final Direction direction;

    public Point(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public Position move() {
        if (direction.isRight()) {
            return position.goNext();
        }
        if (direction.isLeft()) {
            return position.goBack();
        }
        return position;
    }

    public static Point first(boolean nextDirection) {
        return new Point(Position.first(), Direction.first(nextDirection));
    }

    public Point next(boolean nextDirection) {
        return new Point(position.goNext(), direction.next(nextDirection));
    }

    public Point last() {
        return new Point(position.goNext(), direction.last());
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return position == point.position && Objects.equals(direction, point.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, direction);
    }
}
