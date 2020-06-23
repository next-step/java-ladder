package ladder.domain.ladder;

import ladder.domain.strategy.LineStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LadderLine {

    private final List<Point> points;

    private LadderLine(List<Point> points) {
        this.points = points;
    }

    public static LadderLine of(int countOfPerson, LineStrategy lineStrategy) {
        List<Point> points = new ArrayList<>();
        Point firstPoint = addFirstPoint(points, lineStrategy);
        Point lastMiddlePoint = addMiddlePoint(countOfPerson, points, firstPoint, lineStrategy);
        addLastPoint(points, lastMiddlePoint);
        return new LadderLine(points);
    }

    private static Point addFirstPoint(List<Point> points, LineStrategy lineStrategy) {
        Point point = Point.first(lineStrategy.hasLine());
        points.add(point);
        return point;
    }

    private static Point addMiddlePoint(int countOfPerson, List<Point> points, Point lastPoint, LineStrategy lineStrategy) {
        for (int i = 1; i < countOfPerson - 1; i++) {
            lastPoint = lastPoint.next(lineStrategy);
            points.add(lastPoint);
        }
        return lastPoint;
    }

    private static void addLastPoint(List<Point> points, Point point) {
        points.add(point.last());
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
