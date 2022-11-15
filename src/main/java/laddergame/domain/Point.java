package laddergame.domain;

import laddergame.util.ValueGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Point {

    private static final Map<Boolean, Point> cache;

    private final boolean point;

    static {
        cache = new HashMap<>();
        cache.put(true, new Point(true));
        cache.put(false, new Point(false));
    }

    private Point(boolean point) {
        this.point = point;
    }

    public static Point valueOf(Boolean value) {
        return cache.get(value);
    }

    public Point next(ValueGenerator valueGenerator) {
        boolean next = valueGenerator.generate();
        if (isExist()) {
            return new Point(false);
        }
        return new Point(next);
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

    @Override
    public String toString() {
        return "Point{" +
                "point=" + point +
                '}';
    }

    public boolean isExist() {
        return this.point;
    }
}

