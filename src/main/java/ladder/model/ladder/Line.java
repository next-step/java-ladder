package ladder.model.ladder;

import ladder.model.point.Point;
import ladder.model.point.Points;

import java.util.*;

public class Line {

    private static final Random random = new Random();
    private final Points points;

    public Line(Points points) {
        this.points = points;
    }

    public static Line init(int countOfPerson) {
        return new Line(initPoints(countOfPerson));
    }

    private static Points initPoints(int countOfPerson) {
        List<Point> points = new ArrayList<Point>();
        Point current = initFirst(points);
        current = initBody(countOfPerson, points, current);
        initLast(points, current);
        return new Points(points);
    }

    private static Point initFirst(List<Point> points) {
        Point first = Point.first(random.nextBoolean());
        points.add(first);
        return first;
    }

    private static Point initBody(int countOfPerson, List<Point> points, Point current) {
        for(int idx = 1; idx < countOfPerson - 1; idx++) {
            current = current.next(random.nextBoolean());
            points.add(current);
        }
        return current.next(random.nextBoolean());
    }

    private static void initLast(List<Point> points, Point current) {
        current = current.last();
        points.add(current);
    }

    public Points points() {
        return points;
    }

    public int move(int index) {
        return this.points.move(index);
    }
}
