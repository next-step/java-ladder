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
        return new Point(Position.first(), Direction.first(pointStrategy));
    }

    public Point last() {
        return new Point(position.next(), direction.last());
    }

    public Point next(PointStrategy pointStrategy) {
        return new Point(position.next(), direction.next(pointStrategy));
    }

    public int move() {
        return position.getValue() + direction.move();
    }

    public boolean isLeft() {
        return this.direction.isLeft();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(position, point.position) &&
                Objects.equals(direction, point.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, direction);
    }
}
