package ladder;

import java.util.ArrayList;
import java.util.List;

public class PointGenerator {
    private final int playerCount;
    private final DirectionGenerator directionGenerator;

    public PointGenerator(int playerCount, DirectionGenerator directionGenerator) {
        this.playerCount = playerCount;
        this.directionGenerator = directionGenerator;
    }

    public List<Point> generate() {
        List<Point> points = new ArrayList<>();
        Point first = initFirstPoint(points);
        Point lastMiddle = initMiddlePoints(points, first);
        initLastPoint(points, lastMiddle);
        return points;
    }

    private Point initFirstPoint(List<Point> points) {
        Point first = Point.first(directionGenerator.generate());
        points.add(first);
        return first;
    }

    private Point initMiddlePoints(List<Point> points, Point point) {
        for (int i = 1; i < playerCount - 1; i++) {
            point = point.next(directionGenerator.generate());
            points.add(point);
        }
        return point;
    }

    private void initLastPoint(List<Point> points, Point point) {
        points.add(point.last());
    }
}
