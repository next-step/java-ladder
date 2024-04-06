package nextstep.ladder.domain;

import java.util.List;

public class Line {
    private List<Point> points;

    Line(List<Point> points) {
        validate(points);
        this.points = points;
    }

    private static void validate(List<Point> points) {
        validatePointsListSize(points);
        validatePointMovements(points);
    }

    private static void validatePointsListSize(List<Point> points) {
        if (points == null || points.isEmpty()) {
            throw new IllegalArgumentException("점이 없습니다.");
        }

        if (points.size() < 2) {
            throw new IllegalArgumentException("점이 두 개 이상 있어야 합니다.");
        }
    }

    private static void validatePointMovements(List<Point> points) {
        if (firstPoint(points).canMoveLeft() || lastPoint(points).canMoveRight()) {
            throw new IllegalArgumentException("첫 점에서는 왼쪽으로 이동할 수 없고, 마지막 점에서는 오른쪽으로 이동할 수 없습니다.");
        }

        for (int i = 0; i < points.size() - 1; i++) {
            assertConsecutivePointsAreMovable(points, i);
        }
    }

    private static void assertConsecutivePointsAreMovable(List<Point> points, int i) {
        if (!hasMovableConnectionToNext(points, i)) {
            throw new IllegalArgumentException("연속된 점에서는 서로 이동 가능해야 합니다.");
        }
    }

    private static boolean hasMovableConnectionToNext(List<Point> points, int i) {
        return points.get(i).canMoveRight() && points.get(i + 1).canMoveLeft();
    }

    private static Point firstPoint(List<Point> points) {
        return points.get(0);
    }

    private static Point lastPoint(List<Point> points) {
        return points.get(points.size() - 1);
    }

    public int width() {
        return points.size();
    }

    public Point getPoint(int index) {
        return points.get(index);
    }
}
