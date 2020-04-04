package nextstep.ladder;

import java.util.Objects;

public class Point {
    private final int point;
    private boolean nextPoint = false;

    public Point(int point) {
        this.point = point;
    }

    public void moveNextPoint() {
        nextPoint = true;
    }

    public int getPoint() {
        return point;
    }

    public boolean isNextPoint() {
        return nextPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (!(o instanceof Point)) { return false; }
        final Point point1 = (Point) o;
        return getPoint() == point1.getPoint() &&
               isNextPoint() == point1.isNextPoint();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPoint(), isNextPoint());
    }
}
