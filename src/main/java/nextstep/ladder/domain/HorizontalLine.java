package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class HorizontalLine {

    private final List<Point> points;

    private HorizontalLine(List<Point> points) {
        this.points = points;
    }

    public static HorizontalLine createLineWithPoints(int numberOfPeople) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points);
        point = initBody(numberOfPeople, points, point);
        initLast(points, point);
        return new HorizontalLine(points);
    }

    private static Point initFirst(List<Point> points) {
        Point point = Point.first(new RandomPointGenerator().generatePoint());
        points.add(point);
        return point;
    }

    private static Point initBody(int numberOfPeople, List<Point> points, Point point) {
        for (int i = 1; i < numberOfPeople - 1; i++) {
            point = point.next();
            points.add(point);
        }
        return point;
    }

    private static void initLast(List<Point> points, Point point) {
        points.add(point.last());
    }

    public List<Point> points() {
        return this.points;
    }
}
