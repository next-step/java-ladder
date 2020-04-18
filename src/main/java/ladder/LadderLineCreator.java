package ladder;

import java.util.ArrayList;
import java.util.List;

public class LadderLineCreator {

    public static LadderLine create(int playerCount, DirectionGenerator directionGenerator) {
        List<Point> points = new ArrayList<>();
        Point lastPoint = initFirstPoint(points, directionGenerator);
        for (int i = 1; i < playerCount - 1; i++) {
            lastPoint = lastPoint.next(directionGenerator.generate());
            points.add(lastPoint);
        }
        initLastPoint(points, lastPoint);
        return new LadderLine(points);
    }

    private static Point initFirstPoint(List<Point> points, DirectionGenerator directionGenerator) {
        Point first = Point.first(directionGenerator.generate());
        points.add(first);
        return first;
    }

    private static void initLastPoint(List<Point> points, Point point) {
        points.add(point.last());
    }
}
