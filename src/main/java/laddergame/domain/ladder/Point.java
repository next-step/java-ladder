package laddergame.domain.ladder;

import java.util.Objects;

public class Point {
    private boolean value;

    public Point() {
        this.value = false;
    }

    public Point(boolean value) {
        this.value = value;
    }

    public void selectPoint(Point previousPoint, SelectStrategy selectStrategy) {
        if (previousPoint.value) {
            return;
        }
        if (selectStrategy.canSelect()) {
            value = true;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return value == point.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
