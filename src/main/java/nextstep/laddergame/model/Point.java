package nextstep.laddergame.model;

import java.util.Objects;

public class Point {

    private static final int FALSE = 0;

    private final boolean isLine;

    public Point(int isLine) {
        this(convertToBoolean(isLine));
    }

    private static boolean convertToBoolean(int isLine) {
        if (isLine == FALSE) {
            return false;
        }
        return true;
    }

    public Point(boolean isLine) {
        this.isLine = isLine;
    }

    public static Point empty() {
        return new Point(false);
    }

    public boolean hasLine() {
        return isLine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return isLine == point.isLine;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isLine);
    }
}
