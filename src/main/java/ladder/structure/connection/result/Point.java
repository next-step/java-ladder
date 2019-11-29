package ladder.structure.connection.result;

import ladder.structure.connection.ConnectionStrategy;

import java.util.Objects;

public class Point {
    private final int point; // 줄번호
    private int openToRight; // 방향

    private Point(int num) {
        this.point = num;
    }

    public static Point of(int num) {
        Point point = new Point(num);
        return point;
    }

    public void firstOf(ConnectionStrategy connectionStrategy) {
        boolean connected = connectionStrategy.create();
        if (connected) {
            this.openToRight = 1;
            return;
        }
        this.openToRight = 0;
    }

    public void of(Point before, ConnectionStrategy connectionStrategy) {
        if (before.openToRight == 1) {
            this.openToRight = -1;
            return;
        }
        boolean connected = connectionStrategy.create();
        if (connected) {
            this.openToRight = 1;
            return;
        }
        this.openToRight = 0;
    }

    public void lastOf(Point before) {
        if (before.openToRight == 1) {
            this.openToRight = -1;
            return;
        }
        this.openToRight = 0;
    }

    public int getOpenToRight() {
        return openToRight;
    }

    public Point move() {
        return Point.of(this.point + openToRight);
    }

    @Override
    public String toString() {
        return "Point{" + "point=" + point + '}';
    }

    public int value() {
        return point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point1 = (Point) o;
        return point == point1.point;
    }

    @Override
    public int hashCode() {
        return Objects.hash(point);
    }
}
