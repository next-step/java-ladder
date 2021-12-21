package ladder.generator;

import ladder.domain.ladder.Line;
import ladder.domain.ladder.Point;
import ladder.strategy.LineStrategy;

import java.util.ArrayList;
import java.util.List;

public class DefaultLineGenerator implements LineGenerator {

    private final LineStrategy strategy;

    public DefaultLineGenerator(LineStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public Line generate(int countOfPlayers) {
        List<Point> points = new ArrayList<>();
        Point point = createFirstPoint(strategy, points);
        for (int i = 1; i < countOfPlayers - 1; i++) {
            point = Point.middle(point, strategy.isEnableLine());
            points.add(point);
        }
        createLastPoint(points, point);
        return Line.createLine(points);
    }

    private static Point createFirstPoint(LineStrategy strategy, List<Point> points) {
        Point point = Point.first(strategy.isEnableLine());
        points.add(point);
        return point;
    }

    private static void createLastPoint(List<Point> points, Point point) {
        point = Point.last(point);
        points.add(point);
    }

}
