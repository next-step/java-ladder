package nextstep.ladder.domain;

import nextstep.ladder.strategy.ConnectStrategy;

import java.util.Objects;

public class Point {
    private final int index;
    private final Direction direction;

    public Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    public static Point first(ConnectStrategy connectStrategy) {
        return new Point(0, Direction.first(connectStrategy));
    }

    public Point next() {
        return new Point(index + 1, direction.next());
    }

    public Point next(ConnectStrategy connectStrategy) {
        return new Point(index + 1, direction.next(connectStrategy));
    }

    public Point last() {
        return new Point(index + 1, direction.last());
    }

    public boolean isConnected() {
        return direction.hasAnyDirection();
    }

    public int move() {
        return index + direction.move();
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
