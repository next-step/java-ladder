package ladder.domain.Ladder;

import java.util.Objects;

public class Point {

    private final boolean Exists;

    public Point(PointPredicate predicate) {
        this(predicate.exists());
    }

    public Point(boolean Exists) {
        this.Exists = Exists;
    }

    public boolean isEqualToTrue(Point y) {
        return y.Exists && this.Exists;
    }

    public boolean isMovable() {
        return this.Exists;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return Exists == point.Exists;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Exists);
    }
}
