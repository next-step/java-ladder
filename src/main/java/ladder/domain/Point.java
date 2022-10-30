package ladder.domain;

import java.util.Objects;
import java.util.Random;

public class Point {

    private final boolean exist;

    public static Point of(boolean value) {
        return new Point(value);
    }

    public Point() {
        this.exist = new Random().nextBoolean();
    }

    public Point(boolean exist) {
        this.exist = exist;
    }
    public boolean isExist() {
        return exist;
    }

    Point nextPoint() {
        if (isExist()) {
            return new Point(false);
        }
        return new Point();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return exist == point.exist;
    }

    @Override
    public int hashCode() {
        return Objects.hash(exist);
    }
}
