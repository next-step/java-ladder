package nextstep.ladder.domain;

import nextstep.ladder.strategy.DirectionStrategy;

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

    public Point next(DirectionStrategy directionStrategy) {
        if (direction.rightSide()) {
            return new Point(index + 1, direction.unConnectedNext());
        }

        return new Point(index + 1, direction.next(directionStrategy));
    }

    public Point last() {
        return new Point(index + 1, direction.last());
    }

    public int move() {
        return index + direction.move();
    }

    public boolean hasLeftDirection() {
        return direction.hasLeftDirection();
    }

    public boolean hasRightDirection() {
        return direction.hasRightDirection();
    }

    public boolean isNotLast(int countOfPlayer) {
        return index + 1 != countOfPlayer - 1;
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
