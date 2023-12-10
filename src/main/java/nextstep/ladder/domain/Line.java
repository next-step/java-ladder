package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Point> points;

    private Line(List<Point> points) {
        if (points == null || points.isEmpty()) {
            throw new IllegalArgumentException("라인은 최소 1개 이상의 포인트가 있어야 합니다.");
        }

        this.points = points;
    }

    public static Line from(List<Point> points) {
        return new Line(points);
    }

    public static Line from(int countOfPoint) {
        List<Point> points = new ArrayList<>();
        Point point = Point.randomInstance();
        points.add(point);

        for (int idx = 1; idx < countOfPoint - 1; idx++) {
            Point nextPoint = point.nextPoint();
            points.add(nextPoint);
            point = nextPoint;
        }

        return new Line(points);
    }

    public List<Point> points() {
        return new ArrayList<>(points);
    }

    private boolean moveLeft(int curPosition) {
        if (curPosition <= 0) {
            return false;
        }

        return points.get(curPosition - 1).isActive();
    }

    private boolean moveRight(int curPosition) {
        if (curPosition >= points.size()) {
            return false;
        }

        return points.get(curPosition).isActive();
    }

    public int nextPosition(int curPosition) {
        if (moveLeft(curPosition)) {
            return curPosition - 1;
        }

        if (moveRight(curPosition)) {
            return curPosition + 1;
        }

        return curPosition;
    }
}