package nextstep.ladder.model.ladder;

public class Point {

    private final boolean value;

    private Point(boolean point) {
        this.value = point;
    }

    public static Point isFalse() {
        return Point.of(false);
    }

    public static Point isTrue() {
        return Point.of(true);
    }

    public static Point of(boolean point) {
        return new Point(point);
    }

    public boolean value() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
