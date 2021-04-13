package nextstep.ladder.domain;

public class Point {

    private Point() {}

    public static Point first(Boolean connected) {
        return new Point();
    }

    public int move() {
        return -1;
    }

    public Point next(Boolean connected) {
    }

    public Point next() {
    }
}
