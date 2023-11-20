package ladder.domain;

import ladder.stretagy.PointBuildStrategy;

import java.util.Objects;

public class Point {

    private final boolean point;

    public Point(boolean point) {
        this.point = point;
    }

    public Point nextPoint(PointBuildStrategy pointBuildStrategy) {
        if (this.point) {
            return new Point(false);
        }
        return new Point(pointBuildStrategy.build());
    }

    public boolean canDraw() {
        return this.point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point1 = (Point) o;
        return point == point1.point;
    }

    @Override
    public int hashCode() {
        return Objects.hash(point);
    }
}
