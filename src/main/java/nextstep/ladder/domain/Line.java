package nextstep.ladder.domain;

import java.util.List;

public class Line {
    private static final String EQUAL_TWO_POINTS_ERROR = "두 사다리는 연속으로 등장할 수 없습니다.";

    private final List<Point> points;

    public Line(List<Point> points) {
        validationLine(points);
        this.points = points;
    }

    private void validationLine(List<Point> points) {
        for (int i = 0; i < points.size() - 1; i++) {
            equalsTwoPoints(points.get(i), points.get(i + 1));
        }
    }

    private void equalsTwoPoints(Point point, Point point2) {
        if (point.getIsStair() && point2.getIsStair()) {
            throw new IllegalArgumentException(EQUAL_TWO_POINTS_ERROR);
        }
    }

    public List<Point> getPoints() {
        return points;
    }
}
