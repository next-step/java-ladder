package nextstep.ladder.domain.strategy;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;

import java.util.ArrayList;
import java.util.List;

public class RandomLineStrategy implements LineStrategy {
    @Override
    public Line createLine(int personCount) {
        List<Point> createdPoints = new ArrayList<>();
        Point point = createFirstPoint(createdPoints);
        point = createMiddlePoints(personCount, point, createdPoints);
        createLastPoint(point, createdPoints);

        return new Line(createdPoints);
    }

    private static Point createFirstPoint(List<Point> createdPoints) {
        Point point = Point.first();
        createdPoints.add(point);
        return point;
    }

    private static Point createMiddlePoints(int personCount, Point point, List<Point> createdPoints) {
        for (int index = 1; index <= personCount - 3; index++) {
            point = point.next();
            createdPoints.add(point);
        }
        return point;
    }

    private static void createLastPoint(Point point, List<Point> createdPoints) {
        point = point.last();
        createdPoints.add(point);
    }
}
