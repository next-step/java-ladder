package step2.ladderGame.domain.ladder;

import java.util.Objects;

public class Point {

    private final boolean hasHorizontalLine;

    public Point() {
        this.hasHorizontalLine = false;
    }

    public Point(boolean previousStatus) {
        this.hasHorizontalLine = previousStatus;
    }

    public boolean hasHorizontalLine() {
        return this.hasHorizontalLine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return hasHorizontalLine == point.hasHorizontalLine;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hasHorizontalLine);
    }
}
