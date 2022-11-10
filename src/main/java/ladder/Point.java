package ladder;

import java.util.Objects;

public class Point {
    private boolean connected;

    public Point(boolean connected) {
        this.connected = connected;
    }

    public boolean connected() {
        return connected;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return connected == point.connected;
    }

    @Override
    public int hashCode() {
        return Objects.hash(connected);
    }

    @Override
    public String toString() {
        return "Point{" +
                "value=" + connected +
                '}';
    }
}
