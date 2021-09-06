package ladderrefactoring.domain.ladder;

import ladderrefactoring.strategy.DirectionStrategy;

import java.util.Objects;

public class Point {

    private static final int TO_LEFT = -1;
    private static final int TO_RIGHT = 1;
    private static final int TO_NEXT = 1;

    private final int index;
    private final Direction direction;

    private Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point of(int index, Direction direction) {
        return new Point(index, direction);
    }

    public static Point first() {
        return new Point(0, Direction.first());
    }

    public Point next() {
        return of(index + TO_NEXT, direction.next());
    }

    public Point last() {
        return of(index + TO_NEXT, direction.last());
    }

    public int move() {
        if(direction.left()) {
            return index + TO_LEFT;
        }

        if(direction.right()) {
            return index + TO_RIGHT;
        }

        return index;
    }

    public Direction direction() {
        return direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return index == point.index && Objects.equals(direction, point.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, direction);
    }
}
