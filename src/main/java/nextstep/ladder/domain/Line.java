package nextstep.ladder.domain;

import java.util.List;

public class Line {
    private List<Point> points;

    Line(List<Point> points) {
        validate(points);
        this.points = points;
    }

    private static void validate(List<Point> points) {
        if (points == null || points.isEmpty()) {
            throw new IllegalArgumentException("점이 없습니다.");
        }

        if (firstPoint(points).canMoveLeft() || lastPoint(points).canMoveRight()) {
            throw new IllegalArgumentException("첫 점에서는 왼쪽으로 이동할 수 없고, 마지막 점에서는 오른쪽으로 이동할 수 없습니다.");
        }
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
