package nextstep.version.refactor.domain;

public class Point {
    private final boolean beforeLine;
    private final boolean current;

    private Point(boolean beforeLine, boolean current) {
        if (beforeLine && current) {
            throw new IllegalArgumentException("라인은 이어질 수 없습니다.");
        }
        this.beforeLine = beforeLine;
        this.current = current;
    }

    public static Point first(boolean current) {
        return new Point(false, current);
    }

    public Point next(boolean current) {
        return new Point(this.current, current);
    }

    public Direction move() {
        if (current) {
            return Direction.NEXT;
        }
        if (beforeLine) {
            return Direction.BEFORE;
        }
        return Direction.PASS;
    }

    public boolean getBeforeLine() {
        return this.beforeLine;
    }

    public boolean getCurrent() {
        return this.current;
    }

    public Point last() {
        return new Point(this.current, false);
    }
}
