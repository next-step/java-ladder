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

    public Point next(final boolean current) {
        return new Point(this.current, current);
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
        return Direction.SOUTH;
    }

}
