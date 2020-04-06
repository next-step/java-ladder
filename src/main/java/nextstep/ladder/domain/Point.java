package nextstep.ladder.domain;

import java.util.Objects;

public class Point {
    private boolean nextPoint = false;

    public Point() {
    }

    public Point(boolean nextPoint) {
        this.nextPoint = nextPoint;
    }

    public void moveNextPoint() {
        nextPoint = true;
    }

    public boolean isNextPoint() {
        return nextPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (!(o instanceof Point)) { return false; }
        final Point point = (Point) o;
        return isNextPoint() == point.isNextPoint();
    }

    @Override
    public int hashCode() {
        return Objects.hash(isNextPoint());
    }
}
