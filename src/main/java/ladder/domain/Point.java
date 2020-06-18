package ladder.domain;

import java.util.Objects;

public class Point {
    private final int index;
    private final Direction direction;

    private Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public int move() {
        if (this.direction.isRight()) {
            return this.index + 1;
        }

        if (this.direction.isLeft()) {
            return this.index - 1;
        }

        return this.index;
    }

    public static Point first(PointGenerationStrategy strategy) {
        return new Point(0, Direction.first(strategy.generate()));
    }

    public Point last() {
        return new Point(this.index +1, this.direction.last());
    }

    public Point next(PointGenerationStrategy strategy) {
        return new Point(this.index + 1, this.direction.next(strategy));
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return index == point.index &&
                Objects.equals(direction, point.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, direction);
    }
}
