package ladder.domain.point;

import ladder.domain.strategy.PointStrategy;

import java.util.Objects;

public class Point {
    private final Position position;
    private final Direction direction;

    private Point(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public static Point first(PointStrategy pointStrategy) {
        return new Point(Position.init(), Direction.first(pointStrategy.next()));
    }

    public Point last() {
        return new Point(position.right(), direction.last());
    }

    public Point next(PointStrategy pointStrategy) {
        return new Point(position.right(), direction.next(pointStrategy));
    }

    public Direction getDirection() {
        return direction;
    }

    public Position move() {
        if (direction.isLeft()) {
            return position.left();
        }

        if (direction.isRight()) {
            return position.right();
        }

        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point that = (Point) o;
        return Objects.equals(position, that.position) &&
                Objects.equals(direction, that.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, direction);
    }
}
