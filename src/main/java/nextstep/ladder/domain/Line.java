package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {

    private final List<Point> points;

    private Line(List<Point> points) {
        validatePoints(points);
        this.points = points;
    }

    private static void validatePoints(List<Point> points) {
        if (points == null || points.isEmpty()) {
            throw new IllegalArgumentException("라인은 최소 1개 이상의 포인트가 있어야 합니다.");
        }

        boolean invalidPoints = IntStream.range(0, points.size() - 1)
                .anyMatch(idx -> points.get(idx).isActive() && points.get(idx + 1).isActive());

        if (invalidPoints) {
            throw new IllegalArgumentException("라인은 연속된 활성 포인트를 가질 수 없습니다.");
        }
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

    private boolean moveLeft(int currentPosition) {
        if (currentPosition <= 0) {
            return false;
        }

        return points.get(currentPosition - 1).isActive();
    }

    private boolean moveRight(int currentPosition) {
        if (currentPosition >= points.size()) {
            return false;
        }

        return points.get(currentPosition).isActive();
    }

    public int nextPosition(int currentPosition) {
        if (moveLeft(currentPosition)) {
            return currentPosition - 1;
        }

        if (moveRight(currentPosition)) {
            return currentPosition + 1;
        }

        return currentPosition;
    }
}