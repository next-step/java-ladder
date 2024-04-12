package nextstep.ladder.domain;

import java.util.Objects;

public class Point {
    private final boolean b;

    public Point(boolean b) {
        this.b = b;
    }

    public boolean isExist() {
        return this.b;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Point point = (Point) object;
        return b == point.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(b);
    }
}
