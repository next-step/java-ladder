package nextstep.step4.impl;


public class Point {
    public static final String INVALID_STATUS_MSG = "두 상태가 true 일 수 없습니다.";
    private static final String EXIST_POINT_STR = "-----";
    private static final String EMPTY_POINT_STR = "     ";
    private final boolean left;
    private final boolean current;

    private Point(final boolean left, final boolean current) {
        if (left && current) {
            throw new IllegalArgumentException(INVALID_STATUS_MSG);
        }

        this.left = left;
        this.current = current;
    }

    public static Point first(boolean current) {
        return new Point(false, current);
    }

    public Point last() {
        return new Point(this.current, false);
    }

    public Point next(final boolean current) {
        return new Point(this.current, current);
    }

    public int move(int position) {
        if (left) {
            return position - 1;
        }

        if (current) {
            return position + 1;
        }

        return position;
    }

    public boolean current() {
        return this.current;
    }

    private String getRadderStr(boolean point) {
        if (point) {
            return EXIST_POINT_STR;
        }

        return EMPTY_POINT_STR;
    }
    @Override
    public String toString() {
        return getRadderStr(this.current);
    }
}
