package step2;

import step2.domain.Location;

import java.util.Objects;

public class Point {

    private final int point;
    private final Location location;

    public Point(int point, Location location) {
        this.point = point;
        this.location = location;
    }

    public Point currentPoint() {
        return new Point(this.point, this.location);
    }

    public Point first() {
        return new Point(0, location.first());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return this.point == point.point && Objects.equals(location, point.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point, location);
    }

    public int move() {
        if (location.isRight()) {
            return point + 1;
        }

        if (location.isLeft()) {
            return point - 1;
        }

        return this.point;
    }
}
