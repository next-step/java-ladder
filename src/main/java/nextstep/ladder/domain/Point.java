package nextstep.ladder.domain;

import java.util.Objects;

public class Point {
    private boolean nextPoint = false;
    private int index;

    public Point() {
    }

    public Point(boolean nextPoint) {
        this.nextPoint = nextPoint;
    }

    public Point(boolean nextPoint, int index) {
        this.nextPoint = nextPoint;
        this.index = index;
    }

    public void drawLine() {
        nextPoint = true;
    }

    public boolean isNextPoint() {
        return nextPoint;
    }

    public int plusIndex() {
        if (nextPoint) {
            ++index;
        }
        return index;
    }

    public int minusIndex() {
        if (nextPoint) {
            --index;
        }
        return index;
    }

    public int judgeIndex(boolean isLeftLine) {
        if (isLeftLine) {
            --index;
            return index;
        }
        if (nextPoint) {
            ++index;
            return index;
        }
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (!(o instanceof Point)) { return false; }
        final Point point = (Point) o;
        return isNextPoint() == point.isNextPoint() &&
               index == point.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isNextPoint(), index);
    }
}
