package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Point> points;

    private Line(List<Point> points) {
        Point current = points.get(0);

        for (Point point : points.subList(1, points.size())) {
            if (!point.canBeNext(current)) {
                throw new IllegalArgumentException("연결된 Point 가 2개 연달아 있을 수 없습니다.");
            }
            current = point;
        }

        this.points = Collections.unmodifiableList(points);
    }

    public static Line ofCandidateCount(int candidatesCount) {
        List<Point> points = new ArrayList<>();
        Point current = Point.point();

        for (int i = 0; i < candidatesCount - 1; i++) {
            Point point = Point.nextOf(current);
            points.add(point);
            current = point;
        }

        return new Line(points);
    }

    public static Line of(Point... points) {
        return new Line(Arrays.asList(points));
    }

    public List<Point> getPoints() {
        return points;
    }
}
