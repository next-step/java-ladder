package ladder.domain;

import java.util.Objects;
import java.util.Random;

public class Point {
    public static final Point CONNECTED = new Point(true);
    public static final Point UNCONNECTED = new Point(false);

    private final boolean isConnected;
    private static final Random random = new Random();

    private Point(boolean isConnected) {
        this.isConnected = isConnected;
    }

    public static Point of(boolean isConnected) {
        if (isConnected) {
            return CONNECTED;
        }
        return UNCONNECTED;
    }

    public static Point point() {
        return new Point(random.nextBoolean());
    }

    public static Point nextOf(Point before) {
        if (before.isConnected) {
            return new Point(false);
        }
        return point();
    }

    public boolean isConnected() {
        return isConnected;
    }

    public boolean canBeNext(Point other) {
        return !(other.isConnected && this.isConnected);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return isConnected == point.isConnected;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isConnected);
    }
}
