package ladder.domain;

public class Point {
    private final boolean point;
    private final LineNumber lineNumber;

    private Point(int index, boolean point) {
        this.lineNumber = LineNumber.valueOf(index);
        this.point = point;
    }

    public static Point of(int index, boolean point) {
        return new Point(index, point);
    }

    public boolean toBoolean() {
        return point;
    }

    public LineNumber getLineNumber() {
        return lineNumber;
    }

    public Point prevCompare(Point prevPoint) {
        if (toBoolean()) {
            return prevPoint;
        }
        return this;
    }

    public Point nextCompare(Point nextPoint) {
        if (!toBoolean() && nextPoint.toBoolean()) {
            return nextPoint;
        }
        return this;
    }

    public Point compare(Point prevPoint, Point nextPoint) {
        return prevCompare(prevPoint).nextCompare(nextPoint);
    }

}
