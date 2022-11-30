package nextstep.ladder.domain;

import nextstep.ladder.exception.IllegalDirectionException;

import java.util.Objects;

public class Point {
    private final Direction direction;

    public Point(Direction direction) {
        this.direction = direction;
    }

    public static Point first(DirectionStrategy strategy) {
        if (strategy.isRight()) {
            return new Point(Direction.RIGHT);
        }
        return new Point(Direction.STRAIGHT);
    }

    public static Point next(Point previous, DirectionStrategy strategy) {
        if (previous.direction == Direction.RIGHT) {
            return new Point(Direction.LEFT);
        }
        if (strategy.isRight()) {
            return new Point(Direction.RIGHT);
        }
        return new Point(Direction.STRAIGHT);
    }

    public static Point last(Point previous, DirectionStrategy strategy) {
        if (previous.direction == Direction.RIGHT) {
            return new Point(Direction.LEFT);
        }
        return new Point(Direction.STRAIGHT);
    }

    public Direction direction() {
        return direction;
    }

    public void validFirst() {
        if (this.direction == Direction.LEFT) {
            throw new IllegalDirectionException("첫번째 점은 왼쪽방향을 가질 수 없습니다");
        }
    }

    public void validLast() {
        if (this.direction == Direction.RIGHT) {
            throw new IllegalDirectionException("마지막 점은 오른쪽 방향을 가질 수 없습니다");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return direction == point.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction);
    }
}
