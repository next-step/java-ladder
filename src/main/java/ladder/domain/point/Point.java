package ladder.domain.point;

import java.util.Objects;

public class Point {

    private static final Point ZERO = new Point(0);
    private static final Point FIVE = new Point(5);

    private final int count;

    private Point(int count) {
        this.count = count;
    }

    public static Point five() {
        return FIVE;
    }

    public static Point zero() {
        return ZERO;
    }

    public boolean isEmpty() {
        return ZERO.equals(this);
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return count == point.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
