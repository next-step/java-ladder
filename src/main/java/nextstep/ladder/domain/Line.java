package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final int MIN_POINT_SIZE = 2;

    private final List<Point> points;

    private Line(List<Point> points) {
        validate(points);
        this.points = points;
    }

    private void validate(List<Point> points) {
        validatePointsListSize(points);
        validatePointMovements(points);
    }

    private void validatePointsListSize(List<Point> points) {
        if (points == null || points.isEmpty()) {
            throw new IllegalArgumentException("점이 없습니다.");
        }

        if (points.size() < MIN_POINT_SIZE) {
            throw new IllegalArgumentException("점이 " + MIN_POINT_SIZE + "개 이상 있어야 합니다.");
        }
    }

    private void validatePointMovements(List<Point> points) {
        if (firstPoint(points).canMoveLeft() || lastPoint(points).canMoveRight()) {
            throw new IllegalArgumentException("첫 점에서는 왼쪽으로 이동할 수 없고, 마지막 점에서는 오른쪽으로 이동할 수 없습니다.");
        }

        for (int i = 0; i < points.size() - 1; i++) {
            assertConsecutivePointsAreMovable(points, i);
        }
    }

    private void assertConsecutivePointsAreMovable(List<Point> points, int i) {
        if (points.get(i).canMoveRight() && !points.get(i + 1).canMoveLeft()) {
            throw new IllegalArgumentException("연속된 점에서는 서로 이동 가능해야 합니다.");
        }
    }

    private Point firstPoint(List<Point> points) {
        return points.get(0);
    }

    private Point lastPoint(List<Point> points) {
        return points.get(points.size() - 1);
    }

    public int width() {
        return points.size();
    }

    public Point getPoint(int index) {
        return points.stream()
                .filter(point -> point.sameIndex(index))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("포인트가 없습니다. index: " + index));
    }

    static class LineBuilder {
        private final List<Point> points;

        public LineBuilder() {
            this.points = new ArrayList<>();
        }

        public LineBuilder point(boolean canMoveRight) {
            if (points.isEmpty()) {
                points.add(Point.createLeftmost(canMoveRight));
                return this;
            }
            points.add(lastPoint().createNext(canMoveRight));
            return this;
        }

        public Line build() {
            if (points.isEmpty()) {
                throw new IllegalStateException("점이 없습니다.");
            }

            points.add(lastPoint().createRightmost());

            return new Line(points);
        }

        private Point lastPoint() {
            return points.get(points.size() - 1);
        }
    }
}
