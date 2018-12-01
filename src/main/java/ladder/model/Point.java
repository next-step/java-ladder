package ladder.model;

import java.util.Objects;

public class Point {
    private static final Point truePoint = new Point(true);
    private static final Point falsePoint = new Point(false);

    private boolean status;

    private Point(boolean status) {
        this.status = status;
    }

    public static Point from(boolean status) {
        return status ? truePoint : falsePoint;
    }

    public boolean isCollapse(Point target) {
        return status && this.equals(target);
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
