package ladder.domain.Ladder;

import java.util.Objects;

public class Point {

    private final boolean isExist;

    public Point(boolean isExist) {
        this.isExist = isExist;
    }

    public boolean isEqualToTrue(Point y) {
        return y.isExist && this.isExist;
    }

    public boolean isMovable() {
        return this.isExist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return isExist == point.isExist;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isExist);
    }
}