package ladder.domain.point;

import ladder.domain.strategy.PointStrategy;

import java.util.Objects;

public class Point {
    private final boolean point;

    private Point(Boolean point) {
        this.point = point;
    }

    public static Point valueOf(Boolean point) {
        return new Point(point);
    }

    public static Point strategyOf(PointStrategy pointStrategy) {
        return new Point(pointStrategy.next());
    }

    public boolean isPoint() {
        return point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point that = (Point) o;
        return point == that.point;
    }

    @Override
    public int hashCode() {
        return Objects.hash(point);
    }
}
