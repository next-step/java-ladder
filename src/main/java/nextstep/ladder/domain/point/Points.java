package nextstep.ladder.domain.point;

import java.util.Arrays;

public class Points {

    private final Point[] points;

    public Points(int size) {
        this.points = setUp(size);
    }

    private Point[] setUp(int size) {
        Point[] points = new Point[size];
        for (int i = 0; i < size; i++) {
            points[i] = Point.EMPTY;
        }
        return points;
    }

    public void connect(int point) {
        validatePoint(point);
        points[point] = Point.CONNECTED;
    }

    public void unUse(int point) {
        validatePoint(point);
        points[point] = Point.UNUSED;
    }

    public boolean connectable(int point) {
        return points[point] != Point.UNUSED;
    }

    public boolean isEmpty(int point) {
        return points[point] == Point.EMPTY;
    }

    public boolean isConnected(int point) {
        return points[point] == Point.CONNECTED;
    }

    public int connectableCount() {
        return (int) Arrays.stream(points)
                .filter(point -> point != Point.UNUSED)
                .count();
    }

    public int size() {
        return points.length;
    }

    public int count(Point point) {
        return (int) Arrays.stream(points)
                .filter(p -> point == p)
                .count();
    }


    @Override
    public String toString() {
        return Arrays.toString(points);
    }

    private void validatePoint(int point) {
        if (points.length <= point)
            throw new IndexOutOfBoundsException("올바르지 않은 포인트입니다");
    }
}
