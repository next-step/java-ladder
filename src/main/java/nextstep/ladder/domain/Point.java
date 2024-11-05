package nextstep.ladder.domain;

import java.util.Objects;

public class Point {

    private final Direction direction;

    public Point(Direction direction) {
        this.direction = direction;
    }

    public Point(boolean left, boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("유효하지 않은 상태입니다.");
        }
        direction = determineDirection(left, right);
    }

    private Direction determineDirection(boolean left, boolean right) {
        if (left) {
            return Direction.LEFT;
        }
        if (right) {
            return Direction.RIGHT;
        }
        return Direction.DOWN;
    }

    public static Point first(boolean right) {
        return new Point(false, right);
    }

    public Point next(boolean next) {
        if (isRightDirection()) {
            return new Point(Direction.LEFT);
        }
        return new Point(false, next);
    }

    public Point last() {
        if (isRightDirection()) {
            return new Point(Direction.LEFT);
        }
        return new Point(Direction.DOWN);
    }

    public Direction move() {
        return direction;
    }

    public boolean isRightDirection() {
        return Direction.RIGHT == direction;
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
