package ladder.domain;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Point point1 = (Point)o;
        return point == point1.point && Objects.equals(lineNumber, point1.lineNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point, lineNumber);
    }
}
