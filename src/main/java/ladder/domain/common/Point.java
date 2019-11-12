package ladder.domain.common;

import java.util.Objects;

public class Point {
    private final int x;
    private final int y;

    public static Point moveDown(Point point) {
        return new Point(point.x, point.y + 1);
    }

    public static Point moveLeft(Point point) {
        return new Point(point.x - 1, point.y);
    }

    public static Point moveRight(Point point) {
        return new Point(point.x + 1, point.y);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point point, int y) {
        this.x = point.x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
