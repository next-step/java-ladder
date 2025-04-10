package nextstep.ladder.domain.line;

import java.util.Objects;

public class Point {
    private final boolean value;

    public Point(boolean point) {
        this.value = point;
    }

    public boolean getValue() {
        return value;
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
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "Point{" +
            "value=" + value +
            '}';
    }
}
