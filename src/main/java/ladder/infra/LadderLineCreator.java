package ladder.infra;

import ladder.domain.DirectionCreator;
import ladder.domain.LadderLine;
import ladder.domain.Point;

import java.util.ArrayList;
import java.util.List;

public class LadderLineCreator {
    public LadderLine create(int playerCount, DirectionCreator directionCreator) {
        List<Point> points = new ArrayList<>();
        Point lastPoint = initFirstPoint(points, directionCreator);
        int middlePointCount = playerCount - 2;
        for (int i = 0; i < middlePointCount; i++) {
            lastPoint = lastPoint.next(directionCreator.create());
            points.add(lastPoint);
        }
        initLastPoint(points, lastPoint);
        return new LadderLine(points);
    }

    private Point initFirstPoint(List<Point> points, DirectionCreator directionCreator) {
        Point first = Point.first(directionCreator.create());
        points.add(first);
        return first;
    }

    private void initLastPoint(List<Point> points, Point point) {
        points.add(point.last());
    }
}
