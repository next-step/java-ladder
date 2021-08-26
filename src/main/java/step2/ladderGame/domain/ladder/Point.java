package step2.ladderGame.domain.ladder;

import java.util.Objects;

public class Point {

    private final boolean status;

    public Point() {
        this.status = false;
    }

    public Point(boolean previousStatus) {
        this.status = previousStatus;
    }

    public boolean getStatus() {
        return this.status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return status == point.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(status);
    }
}
