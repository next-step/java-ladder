package ladderrefactoring.domain.ladder;

import ladderrefactoring.strategy.DirectionStrategy;

import java.util.Objects;

public class Point {

    private final int index;
    private final Direction direction;

    private Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point first(DirectionStrategy directionStrategy) {
        return new Point(0, Direction.first(directionStrategy));
    }

    public static Point of(Point pointBefore, DirectionStrategy directionStrategy) {
        return new Point(pointBefore.index + 1, Direction.of(pointBefore.direction, directionStrategy));
    }

    public static Point last(Point pointBefore) {
        return new Point(pointBefore.index + 1, Direction.last(pointBefore.direction));
    }

    public int move() {
        if(direction.left()) {
            return index - 1;
        }

        if(direction.right()) {
            return index + 1;
        }

        return index;
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
