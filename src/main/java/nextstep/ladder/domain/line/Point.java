package nextstep.ladder.domain.line;

import java.util.Objects;
import java.util.Random;

public class Point {
    private static final Random random = new Random();
    private final boolean value;

    public static Point lineRandomPoint(Point prevPoint) {
        if (prevPoint.value) {
            return new Point(false);
        }
        return new Point(random.nextBoolean());
    }

    public Point(boolean point) {
        this.value = point;
    }

    public boolean isConnected() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return value == point.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
