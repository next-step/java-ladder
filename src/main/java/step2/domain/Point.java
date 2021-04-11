package step2.domain;

import java.util.Objects;

public class Point {
    private final boolean hasLine;

    public Point(boolean hasLine) {
        this.hasLine = hasLine;
    }

    public static Point first(BooleanGenerator booleanGenerator) {
        return new Point(booleanGenerator.nextBoolean());
    }

    public static Point last() {
        return new Point(false);
    }

    public boolean hasLine() {
        return hasLine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return hasLine == point.hasLine;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hasLine);
    }
}
