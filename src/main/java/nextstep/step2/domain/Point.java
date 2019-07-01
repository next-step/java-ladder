package nextstep.step2.domain;

import java.util.Objects;

public class Point {
    private final Boolean point;

    private Point(final boolean point) {
        this.point = point;
    }

    public static Point create(final boolean point) {
        return new Point(point);
    }

    public static Point create(final PointCreationStrategy strategy) {
        return new Point(strategy.isCreation());
    }

    public boolean isPoint() {
        return point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Point point1 = (Point) o;
        return Objects.equals(point, point1.point);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point);
    }

    @Override
    public String toString() {
        return point.toString();
    }
}
