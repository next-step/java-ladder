package ladder.domain;

import java.util.Objects;

public class Point {
    private final boolean point;

    private Point(Boolean point) {
        this.point = point;
    }

    public static Point of(Boolean point) {
        return new Point(point);
    }

    public static Point ofStrategy(PointGenerationStrategy pointGenerationStrategy) {
        return new Point(pointGenerationStrategy.generate());
    }

    public boolean isPoint() {
        return point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point1 = (Point) o;
        return point == point1.point;
    }

    @Override
    public int hashCode() {
        return Objects.hash(point);
    }
}
