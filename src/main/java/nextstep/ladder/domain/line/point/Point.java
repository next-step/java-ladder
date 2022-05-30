package nextstep.ladder.domain.line.point;

import nextstep.ladder.domain.BooleanGenerator;

import java.util.Objects;

public class Point {
    private static final String STICK = "|";
    private static final String EDGE = "-----";
    private static final String EMPTY = "     ";

    private final boolean point;

    public Point(boolean point) {
        this.point = point;
    }

    public static Point of(BooleanGenerator booleanGenerator) {
        return new Point(booleanGenerator.generate());
    }

    public boolean isTrue() {
        return this.point == true;
    }

    public boolean isFalse() {
        return this.point == false;
    }

    public String getEdgeOrEmpty() {
        if (isTrue()) {
            return STICK + EDGE;
        }

        return STICK + EMPTY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Point point1 = (Point) o;
        return point == point1.point;
    }

    @Override
    public int hashCode() {
        return Objects.hash(point);
    }
}
