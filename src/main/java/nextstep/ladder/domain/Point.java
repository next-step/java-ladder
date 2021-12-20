package nextstep.ladder.domain;

import java.util.Objects;

public class Point {
    private static final int LEFT = -1;
    private static final int RIGHT = 1;
    private static final int NOW = 0;

    private final boolean value;

    public Point(boolean value) {
        this.value = value;
    }

    public boolean isValue() {
        return value;
    }

    public int checkDirection(Point left) {
        if (left.isValue()) {
            return LEFT;
        }

        if(this.isValue()) {
            return RIGHT;
        }

        return NOW;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return value == point.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
