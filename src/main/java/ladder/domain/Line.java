package ladder.domain;

import java.util.ArrayList;
import java.util.List;

import static ladder.domain.PointGenerator.generatePoint;

public class Line {
    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public static Line init(int count) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points);
        point = initBody(count, points, point);
        initLast(points, point);

        return new Line(points);
    }

    private static void initLast(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }

    private static Point initBody(int sizeOfCount, List<Point> points, Point point) {
        for (int i = 1; i < sizeOfCount - 1; i++) {
            point = point.next();
            points.add(point);
        }
        return point;
    }

    private static Point initFirst(List<Point> points) {
        Point point = Point.first(generatePoint());
        points.add(point);
        return point;
    }

    public List<Point> getPoints() {
        return points;
    }
}
