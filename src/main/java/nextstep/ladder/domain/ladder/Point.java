package nextstep.ladder.domain.ladder;

public class Point {
    private final boolean connect;
    private final static Point cacheTruePoint;
    private final static Point cacheFalsePoint;

    static {
        cacheTruePoint = new Point(true);
        cacheFalsePoint = new Point(false);
    }

    private Point(boolean connect) {
        this.connect = connect;
    }

    public static Point of(boolean connect) {
        return connect ? cacheTruePoint : cacheFalsePoint;
    }

    public boolean isConnect() {
        return connect;
    }
}
