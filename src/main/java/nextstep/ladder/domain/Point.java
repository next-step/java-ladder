package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Point {
    private static final Map<Integer, Point> CACHE = new HashMap<>();
    public static final Point INITIAL_POINT = Point.of(1);

    private final int position;

    private Point(final int position) {
        this.position = position;
    }

    public static Point of(final int position) {
        return CACHE.computeIfAbsent(position, p -> new Point(position));
    }

    public Point add() {
        return Point.of(position + 1);
    }

    public Point before() {
        if (this.position <= 0) {
            throw new IllegalArgumentException(String.format("%d positon은 존재하지 않습니다.", this.position - 1));
        }
        return Point.of(this.position - 1);
    }

    public boolean isUnderThan(final Point point) {
        return this.position < point.position;
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
