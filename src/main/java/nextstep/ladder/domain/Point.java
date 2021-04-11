package nextstep.ladder.domain;

public class Point {
    private final boolean point;

    private Point(boolean point) {
        this.point = point;
    }

    public static Point from(boolean point) {
        return new Point(point);
    }

    public boolean value() {
        return point;
    }
}
