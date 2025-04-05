package ladder.domain;

import java.util.Objects;

public class Point {
    private final boolean rightConnected;

    public Point(boolean rightConnected) {
        this.rightConnected = rightConnected;
    }

    public boolean connected() {
        return rightConnected;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return rightConnected == point.rightConnected;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(rightConnected);
    }
}
