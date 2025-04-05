package ladder.domain;

import java.util.Objects;

public class Point {
    private final boolean rightConnected;

    public Point(boolean rightConnected) {
        this.rightConnected = rightConnected;
    }

    public Point(ConnectStrategy connectStrategy, int idx) {
        this(connectStrategy.connect(idx));
    }

    public boolean rightConnected() {
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
