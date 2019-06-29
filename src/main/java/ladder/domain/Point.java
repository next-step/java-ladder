package ladder.domain;

public class Point {

    private static final Point TRUE_POINT = new Point(true);
    private static final Point FALSE_POINT = new Point(false);

    private boolean point;

    private Point(boolean point) {

        this.point = point;
    }

    public static Point of(boolean point) {

        if (point) {
            return TRUE_POINT;
        }
        return FALSE_POINT;
    }

    public static Point of(int step, int lineNumber) {

        return Point.of(isOdd(step, lineNumber));
    }

    public boolean isPoint() {

        return point;
    }

    private static boolean isOdd(int step, int lineNumber) {

        return (lineNumber + step) % 2 == 0;
    }
}
