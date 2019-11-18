package ladder.domain;

import java.util.Objects;

public class Point {

    private Boolean type;

    public Point(Boolean type) {
        this.type = type;
    }

    public Boolean getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(type, point.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}
