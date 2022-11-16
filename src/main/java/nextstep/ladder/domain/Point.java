package nextstep.ladder.domain;

import java.util.Objects;

public final class Point {
    private final PointType type;

    private Point(final boolean value) {
        this.type = PointType.valueOf(value);
    }

    public static Point valueOf(final boolean value) {
        return new Point(value);
    }

    public boolean isNode() {
        return this.type.isNode();
    }

    public boolean isConnectedInRow(final Point otherPoint) {
        return isNode() && otherPoint.isNode();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Point point = (Point) o;
        return type == point.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public String toString() {
        return String.format("{ %s }", type);
    }
}
