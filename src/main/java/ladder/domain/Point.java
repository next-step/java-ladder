package ladder.domain;

import java.util.Objects;

public final class Point {

    private final boolean isConnected;

    public Point(boolean isConnected){
        this.isConnected = isConnected;
    }

    public boolean isConnected() {
        return isConnected;
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
