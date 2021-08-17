package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import nextstep.ladder.strategy.RandomStrategy;

public class Line {
    private List<Point> points;

    private Line (List<Point> points) {
        this.points = points;
    }

    public static Line of(int peopleSize, RandomStrategy randomStrategy) {
        List<Point> points = new ArrayList<>();

        Point point = first(points, randomStrategy.createLine());

        for(int i = 1; i < peopleSize - 1; i++) {
            point = between(randomStrategy, points, point);
        }

        last(points, point);
        return new Line(points);
    }

    private static Point between(RandomStrategy randomStrategy, List<Point> points, Point point) {
        point = point.next(randomStrategy.createLine());
        points.add(point);
        return point;
    }

    private static Point first(List<Point> points, boolean line) {
        Point point = Point.first(line);
        points.add(point);
        return point;
    }

    private static void last(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }

    public List<Point> getPoints() {
        return points;
    }
}
