package nextstep.ladder;

import java.util.List;

public class Line {
    public static final String POINT_COUNT_ERROR = "참여자는 2명 이상이어야 합니다.";
    private List<Point> points;

    public Line(List<Point> points) {
        assertPointCount(points);
        this.points = points;
    }

    private void assertPointCount(List<Point> points) {
        if(points.size() < 2) {
            throw new IllegalArgumentException(POINT_COUNT_ERROR);
        }
    }
    public List<Point> getValue() {
        return this.points;
    }
}
