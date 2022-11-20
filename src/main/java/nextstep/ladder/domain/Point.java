package nextstep.ladder.domain;

public class Point {

    private final boolean left;
    private final boolean current;

    private Point(final boolean left, final boolean current) {
        if (left && current) {
            throw new IllegalArgumentException("상태 값이 유효하지 않습니다.");
        }
        this.left = left;
        this.current = current;
    }

    public static Point first(final boolean current) {
        return new Point(false, current);
    }

    public static Point of(final boolean left, final boolean current) {
        return new Point(left, current);
    }

    public Point next(final Movable movable) {
        if (this.current) {
            return next(false);
        }
        return next(movable.generate());
    }

    public Point next(final boolean nextCurrent) {
        return new Point(this.current, nextCurrent);
    }

    public Point last() {
        return new Point(this.current, false);
    }

    public Direction move() {
        if (current) {
            return Direction.RIGHT;
        }
        if (left) {
            return Direction.LEFT;
        }
        return Direction.DOWN;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;

        Point point = (Point) o;

        if (left != point.left) return false;
        return current == point.current;
    }

    @Override
    public int hashCode() {
        int result = (left ? 1 : 0);
        result = 31 * result + (current ? 1 : 0);
        return result;
    }

    public boolean isLeft() {
        return left;
    }
}
