package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Point {
    private static final Map<Integer, Point> CACHE = new HashMap<>();
    private final int position;

    private Point(final int position) {
        this.position = position;
    }

    public static Point of(final int position) {
        return CACHE.computeIfAbsent(position, (p) -> new Point(position));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return position == point.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
