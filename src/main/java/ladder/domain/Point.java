package ladder.domain;

import java.util.Objects;

public class Point {

    private final boolean hasRight;

    public Point(boolean hasRight) {
        this.hasRight = hasRight;
    }

    public boolean hasRight() {
        return hasRight;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return hasRight == point.hasRight;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(hasRight);
    }
}
