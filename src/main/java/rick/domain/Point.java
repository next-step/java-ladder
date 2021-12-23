package rick.domain;

import java.util.Objects;

public class Point {

    public static final Point MOVABLE_POINT = new Point(true);
    public static final Point NON_MOVABLE_POINT = new Point(false);

    private final boolean value;

    public Point(boolean value) {
        this.value = value;
    }

    public boolean movable() {
        return value;
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
        return value == point.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
