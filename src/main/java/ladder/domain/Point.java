package ladder.domain;

import java.util.Objects;

import static ladder.domain.Name.NAME_SIZE;

public class Point {

    private final Boolean point;

    public Point(Boolean point) {
        this.point = point;
    }

    public boolean isTrue() {
        return point == Boolean.TRUE;
    }

    @Override
    public String toString() {
        if (point == null) {
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

        Point point1 = (Point) object;

        return Objects.equals(point, point1.point);
    }

    @Override
    public int hashCode() {
        return point != null ? point.hashCode() : 0;
    }
}
