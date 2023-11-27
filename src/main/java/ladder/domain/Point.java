package ladder.domain;

import java.util.Objects;

import static ladder.domain.Name.NAME_SIZE;

public class Point {

    private final Boolean value;

    public Point(Boolean value) {
        this.value = value;
    }

    public boolean isTrue() {
        return value == Boolean.TRUE;
    }

    @Override
    public String toString() {
        if (value == null) {
            return "|";
        }
        if (isTrue()) {
            return "-".repeat(NAME_SIZE);
        }
        return " ".repeat(NAME_SIZE);
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

        return Objects.equals(value, point.value);
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
