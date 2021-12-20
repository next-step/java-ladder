package ladder.domain.ladder;

import ladder.domain.rule.PositionGenerator;

import java.util.Objects;

public class Point {

    private final int index;
    private final Direction direction;

    Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    static Point first(PositionGenerator current) {
        return new Point(0, Direction.first(current));
    }

    Point next(PositionGenerator current) {
        return new Point(index + 1, direction.next(current));
    }

    Point last() {
        return new Point(index + 1, direction.last());
    }

    int move() {
        return index + direction.move();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return index == point.index && Objects.equals(direction, point.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, direction);
    }
}
