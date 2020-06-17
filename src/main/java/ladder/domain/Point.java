package ladder.domain;

public class Point {
    private static final Point MOVABLE = new Point(true);
    private static final Point STOP = new Point(false);

    private boolean point;

    private Point(boolean point) {
        this.point = point;
    }

    public static Point movable() {
        return MOVABLE;
    }

    public static Point stop() {
        return STOP;
    }

    public Point checkOverlap(boolean random) {
        if (point || !random) {
            return STOP;
        }
        return MOVABLE;
    }

    public boolean isPoint() {
        return point;
    }
}
