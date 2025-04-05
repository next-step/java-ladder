package ladder.domain;

import java.util.Objects;

public class Point {
    private final boolean leftConnected;
    private final boolean rightConnected;

    public Point(boolean leftConnected, boolean rightConnected) {
        this.leftConnected = leftConnected;
        this.rightConnected = rightConnected;
    }

    public boolean leftConnected() {
        return leftConnected;
    }

    public boolean rightConnected() {
        return rightConnected;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return leftConnected == point.leftConnected && rightConnected == point.rightConnected;
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftConnected, rightConnected);
    }
}
