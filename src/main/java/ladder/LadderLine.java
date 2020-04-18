package ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LadderLine {
    private final List<Point> points;

    public static LadderLine of(int playerCount, DirectionGenerator directionGenerator) {
        List<Point> points = new ArrayList<>();
        Point point = initFirstPoint(points, directionGenerator);
        for (int i = 1; i < playerCount - 1; i++) {
            point = point.next(directionGenerator.generate());
            points.add(point);
        }
        points.add(points.get(playerCount - 2).last());
        return new LadderLine(points);
    }

    private static Point initFirstPoint(List<Point> points, DirectionGenerator directionGenerator) {
        Point first = Point.first(directionGenerator.generate());
        points.add(first);
        return first;
    }

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public List<Integer> move() {
        return points.stream()
                .map(Point::move)
                .collect(Collectors.toList());
    }

    public int move(int pointIndex) {
        return points.get(pointIndex).move();
    }
}
