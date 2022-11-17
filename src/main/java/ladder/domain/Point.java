package ladder.domain;

import java.util.Objects;

public class Point {
    private static final Integer INIT_POINT_INDEX = 0;

    private final Boolean left;
    private final Boolean current;
    private final Integer index;

    private Point(Boolean left, Boolean current, Integer index) {
        this.left = left;
        this.current = current;
        this.index = index;
    }

    public static Point first(boolean isConnected) {
        return new Point(false, isConnected, INIT_POINT_INDEX);
    }

    public Point next(boolean isConnected) {
        boolean next = isConnected;
        if (this.current && next) {
            next = false;
        }
        return new Point(this.current, next, this.index + 1);
    }

    public Point last() {
        return new Point(this.current, false, this.index + 1);
    }

    public Boolean getCurrent() {
        return current;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(left, point.left) && Objects.equals(current, point.current) && Objects.equals(index, point.index);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, current, index);
    }
}
