package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import nextstep.ladder.strategy.RandomStrategyImpl;

public class Line {
    private List<Point> points;

    private Line (List<Point> points) {
        this.points = points;
    }

    public static Line of(int peopleSize) {
        List<Point> points = new ArrayList<>();
        Point point = first(points);
        point = between(peopleSize, points, point);
        last(points, point);
        return new Line(points);
    }

    private static Point first(List<Point> points) {
        Point point = Point.first(getRandomSet());
        points.add(point);
        return point;
    }

    private static Point between(int peopleSize, List<Point> points, Point point) {
        for(int i = 1; i < peopleSize - 1; i++) {
            point = point.next(getRandomSet());
            points.add(point);
        }
        return point;
    }

    private static void last(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }

    private static boolean getRandomSet() {
        return new RandomStrategyImpl().createLine();
    }

    public List<Point> getPoints() {
        return points;
    }
}
