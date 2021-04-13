package ladder.domain;

import java.util.List;
import java.util.Objects;

public class LadderLine {
    private final List<Point> points;

    public LadderLine(List<Point> points) {
        if (!points.isEmpty()) {
            validateLast(points);
            validateContinuous(points);
        }

        this.points = points;
    }

    private void validateLast(List<Point> points) {
        if (points.get(points.size() - 1) == Point.BEGIN) {
            throw new IllegalArgumentException();
        }
    }

    private void validateContinuous(List<Point> points) {
        Point prevPoint = Point.COMMON;

        for (Point currentPoint : points) {
            validateContinuous(prevPoint, currentPoint);

            prevPoint = currentPoint;
        }
    }

    private void validateContinuous(Point prevPoint, Point currentPoint) {
        if (!continuous(prevPoint, currentPoint)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean continuous(Point prevPoint, Point currentPoint) {
        if (currentPoint == Point.END) {
            return prevPoint == Point.BEGIN;
        }

        return prevPoint != Point.BEGIN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderLine that = (LadderLine) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
