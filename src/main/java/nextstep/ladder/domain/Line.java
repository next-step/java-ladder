package nextstep.ladder.domain;

import java.util.List;

public class Line {

    private final List<Boolean> points;

    private Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line of(List<Boolean> points) {
        validatePoint(points);
        return new Line(points);
    }

    private static void validatePoint(List<Boolean> points) {
        Boolean prevPoint = points.get(0);
        for (int i = 1; i < points.size(); i++) {
            Boolean currPoint = points.get(i);
            if (prevPoint && currPoint) {
                throw new IllegalArgumentException("사다리 선은 이어질 수 없습니다.");
            }
            prevPoint = currPoint;
        }
    }

    public int size() {
        return points.size();
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
