package ladder.domain.ladder;

import ladder.domain.ladder.ladderInfo.LineCount;

import java.util.ArrayList;
import java.util.List;

import static ladder.domain.util.RandomGenerator.isMovable;

public class LineCreator {

    private LineCreator() { }

    public static Line create(LineCount LineCount) {
        List<Point> points = new ArrayList<>();
        Point point = initFirstPoint(points);
        for (int i = 1; i < LineCount.getLineCount() - 1; i++) {
            point = point.next(isMovable());
            points.add(point);
        }
        initLastPoint(points, point);
        return new Line(points);
    }

    private static Point initFirstPoint(List<Point> points) {
        Point first = Point.first(isMovable());
        points.add(first);
        return first;
    }

    private static void initLastPoint(List<Point> points, Point point) {
        points.add(point.last());
    }
}
