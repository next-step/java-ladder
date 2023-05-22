package ladder.domain;

import ladder.generator.PointGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Point> points;

    public static Line create(List<Point> points) {
        return new Line(points);
    }

    public static Line create(int usersCount, PointGenerator pointGenerator) {
        validateUserCount(usersCount);
        List<Point> points = new ArrayList<>();
        Point currentPoint = Point.createFirst(pointGenerator.generate());
        points.add(Point.createFirst(pointGenerator.generate()));

        for (int i = 1; i < usersCount - 1; i++) {
            Point nextPoint = Point.createNext(currentPoint.canMoveToRight(), pointGenerator.generate());
            points.add(nextPoint);
            currentPoint = nextPoint;
        }
        points.add(Point.createLast(currentPoint.canMoveToRight()));

        return create(points);
    }

    private static void validateUserCount(int usersCount) {
        if (usersCount < 1) {
            throw new IllegalArgumentException("참여자 수는 1명 이상이어야 합니다.");
        }
    }

    public int size() {
        return this.points.size();
    }

    private Line(List<Point> points) {
        validateLine(points);
        this.points = points;
    }

    private void validateLine(List<Point> points) {
        if (isEmpty(points)) {
            throw new IllegalArgumentException("Line is Empty");
        }
    }

    private boolean isEmpty(List<Point> points) {
        return points == null || points.isEmpty();
    }
}
