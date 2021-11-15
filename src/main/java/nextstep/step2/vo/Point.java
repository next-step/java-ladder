package nextstep.step2.vo;

import java.util.Objects;

public class Point {
    private static final Point FALSE = new Point(false);
    private static final Point TRUE = new Point(true);

    private final Boolean value;

    public Point(Boolean value) {
        this.value = value;
    }

    public static Point create(Boolean value) {
        return new Point(value);
    }

    public static Point getCachedPoint(Boolean value) {
        if(value) {
            return TRUE;
        }

        return FALSE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return Objects.equals(value, point.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public boolean isGo() {
        return this.value;
    }
}
