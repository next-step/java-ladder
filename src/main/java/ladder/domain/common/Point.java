package ladder.domain.common;

import java.util.Objects;

public class Point {
    private static final int MOVE = 1;
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Point moveDown(Point point) {
        return new Point(point.x, point.y + MOVE);
    }

    public static Point moveLeft(Point point) {
        return new Point(point.x - MOVE, point.y + MOVE);
    }

    public static Point moveRight(Point point) {
        return new Point(point.x + MOVE, point.y + MOVE);
    }

    public int getX() {
        return x;
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
