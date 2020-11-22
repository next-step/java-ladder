package step4.domain.ladder;

import step4.exceptions.OutOfRangePositionException;

import java.util.Objects;

public class Point {
    public static final Point defaultPoint = new Point(0, 0);
    private final Integer x;
    private final Integer y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
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
        return Objects.equals(x, point.x) &&
                Objects.equals(y, point.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public Point leftMove() {
        if (x <= 0) {
            throw new OutOfRangePositionException();
        }

        return new Point(x-1, y);
    }

    public Point rightMove() {
        return new Point(x+1, y);
    }

    public Point downMove() {
        return new Point(x, y+1);
    }
}
