package nextstep.mission.domain;

import java.util.Objects;

public class Point {
    private static final int RIGHT = 1;
    private static final int LEFT = -1;
    private static final int CURRENT = 0;

    private boolean value;

    public Point(boolean value) {
        this.value = value;
    }

    public static Point of(boolean value) {
        return new Point(value);
    }

    public int move(Point right) {
        if (Point.of(true).equals(right)) {
            return RIGHT;
        }

        if (value) {
            return LEFT;
        }

        return CURRENT;
    }

    public boolean isLeft() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point1 = (Point) o;
        return value == point1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
