package nextstep.ladder.domain;

import java.util.Objects;

public class Point {
    private final boolean left;
    private final boolean current;

    private Point(boolean left, boolean current) {
        twoWayValidate(left, current);
        this.left = left;
        this.current = current;
    }

    private void twoWayValidate(boolean left, boolean current) {
        if(left && current) {
            throw new IllegalArgumentException("두쪽 다리가 전부 있을 수는 없습니다.");
        }
    }

    public static Point first(boolean current) {
        return new Point(false, current);
    }

    public Point next(boolean current) {
        if(this.current && current) {
            return new Point(this.current, false);
        }
        return new Point(this.current, current);
    }

    public Point last() {
        return new Point(this.current, false);
    }

    public Direction move() {
        if(left) {
            return Direction.LEFT;
        }

        if(current) {
            return Direction.RIGHT;
        }

        return Direction.PASS;
    }

    public boolean isLeft() {
        return left;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return left == point.left && current == point.current;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, current);
    }
}
