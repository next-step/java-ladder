package step3.domain;

import java.util.Objects;

public class Point {

    private final int point;
    private final Location location;

    public Point(int point, Location location) {
        this.point = point;
        this.location = location;
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

    public static Point first(boolean right) {
        return new Point(0, Location.first(right));
    }

    public Point next() {
        return new Point(point + 1, location.next());
    }

    public Point next(boolean right) {
        return new Point(point + 1, location.next(right));
    }

    public Point last() {
        return new Point(point + 1, location.last());
    }

    public Location location() {
        return location;
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

    @Override
    public String toString() {
        return "[" +
                point +
                ", " + location +
                "]";
    }
}
