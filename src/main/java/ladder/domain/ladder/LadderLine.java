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
        addFirstPoint(points, lineStrategy);
        addMiddlePoint(countOfPerson, points, lineStrategy);
        addLastPoint(points);
        return new LadderLine(points);
    }

    private static void addFirstPoint(List<Point> points, LineStrategy lineStrategy) {
        Point point = Point.first(lineStrategy.hasLine());
        points.add(point);
    }

    private static void addMiddlePoint(int countOfPerson, List<Point> points, LineStrategy lineStrategy) {
        IntStream.range(1, countOfPerson - 1).forEach(i -> points.add(points.get(i - 1).next(lineStrategy)));
    }

    private static void addLastPoint(List<Point> points) {
        points.add(points.get(points.size() - 1).last());
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
