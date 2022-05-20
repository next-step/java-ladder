package nextstep.ladder.model;

public class Point {

    private final boolean value;

    private Point(boolean point) {
        this.value = point;
    }

    public static Point of(boolean point) {
        return new Point(point);
    }

    public boolean value() {
        return value;
    }
}
