package ladder.model;

import java.util.ArrayList;
import java.util.List;


public class LadderLine {
    private final List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public static LadderLine init(int sizeOfPerson, Difficult difficult) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points, difficult);
        point = initBody(sizeOfPerson, points, point, difficult);
        initLast(points, point);
        return new LadderLine(points);
    }

    private static Point initBody(int sizeOfPerson, List<Point> points, Point point, Difficult difficult) {
        for (int i = 1; i < sizeOfPerson - 1; i++) {
            point = point.next(difficult);
            points.add(point);
        }
        return point;
    }

    private static void initLast(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }

    private static Point initFirst(List<Point> points, Difficult difficult) {
        Point point = Point.first(difficult.generatePoint());
        points.add(point);
        return point;
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "LadderLine{" +
                "points=" + points +
                '}';
    }
}