package nextstep.laddergame.model;

import java.util.Objects;

public class Point {

    private static final int FALSE = 0;

    private final boolean exist;

    public Point(int booleanNumber) {
        this(convertToBoolean(booleanNumber));
    }

    private static boolean convertToBoolean(int booleanNumber) {
        return booleanNumber != FALSE;
    }

    public Point(boolean exist) {
        this.exist = exist;
    }

    public static Point empty() {
        return new Point(false);
    }

    public boolean exist() {
        return exist;
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
        return exist == point.exist;
    }

    @Override
    public int hashCode() {
        return Objects.hash(exist);
    }
}
