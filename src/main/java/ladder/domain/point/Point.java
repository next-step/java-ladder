package ladder.domain.point;

import ladder.domain.strategy.PointStrategy;

import java.util.Objects;

public class Point {
    private final int position;
    private final Direction direction;

    private Point(int position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public static Point first(PointStrategy pointStrategy) {
        return new Point(0, Direction.first(pointStrategy));
    }

    public Point last() {
        return new Point(position + 1, direction.last());
    }

    public Point next(PointStrategy pointStrategy) {
        return new Point(this.position + 1, direction.next(pointStrategy));
    }

    public int move() {
        return position + direction.move();
    }

    public boolean isLeft() {
        return this.direction.isLeft();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return position == point.position &&
                Objects.equals(direction, point.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, direction);
    }
}
