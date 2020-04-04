package nextstep.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Line {
    public static final String POINT_COUNT_ERROR = "참여자는 2명 이상이어야 합니다.";
    public static final String POINT_HAS_LINE_ERROR = "가로 라인이 겹치면 어느 방향으로 이동할 지 결정할 수 없습니다.";
    private List<Point> points;

    public Line(List<Point> points) {
        assertPointCount(points);
        assertPointHasLine(points);
        this.points = points;
    }

    public Line(int personCount) {
        this(createLine(personCount));
    }

    private static List<Point> createLine(int personCount) {
        List<Point> points = Stream
                .generate(() -> new Point(0, true))
                .limit(personCount - 1)
                .collect(Collectors.toList());

        return points;
    }

    private void assertPointHasLine(List<Point> points) {

        for(int i = 0; i < points.size(); i++) {
            if(i != 0) {
                Point leftPoint = points.get(i - 1);
                if(leftPoint.hasLine() && points.get(i).hasLine()) {
                    throw new IllegalArgumentException(POINT_HAS_LINE_ERROR);
                }
            }
        }
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
