package nextstep.ladder.domain;

public class Point {
    private final boolean left;
    private final boolean current;

    private Point(boolean left, boolean current) {
        if(left && current) {
            throw new IllegalArgumentException("두쪽 다리가 전부 있을 수는 없습니다.");
        }
        this.left = left;
        this.current = current;
    }

    public static Point first(boolean current) {
        return new Point(false, current);
    }

    public Point next(boolean current) {
        if(this.current == current) {
            return new Point(this.current, !current);
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
}
