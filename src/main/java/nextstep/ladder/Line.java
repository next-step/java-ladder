package nextstep.ladder;

import java.util.List;

public class Line {

    public static final int MIN_COUNT = 1;

    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public static Line of(List<Point> points) {
        validateSize(points);
        return new Line(points);
    }

    private static void validateSize(List<Point> points) {
        if (points.size() < MIN_COUNT) {
            throw new IllegalArgumentException("최소 1개 이상의 Point가 필요합니다.");
        }
    }
}
