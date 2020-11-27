package step03.domain;

import java.util.Objects;

public class Point {
    private final Boolean hasLine;

    private Point(Boolean hasLine) {
        this.hasLine = hasLine;
    }

    public static Point of(Boolean hasLine) {
        return new Point(hasLine);
    }

    public Boolean hasLine() {
        return hasLine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(hasLine, point.hasLine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hasLine);
    }

}
