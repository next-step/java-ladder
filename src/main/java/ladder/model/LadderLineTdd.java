package ladder.model;

import java.util.ArrayList;
import java.util.List;

import static ladder.model.Point.generatePoint;

public class LadderLineTdd {
    private final List<Point> points;

    public LadderLineTdd(final List<Point> points) {
        this.points = points;
    }

    public int move(final int position) {
        return points.get(position).move();
    }

    public static LadderLineTdd init(final int sizeOfPerson) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points);
        point = initBody(sizeOfPerson, points, point);
        initLast(points, point);
        return new LadderLineTdd(points);
    }

    private static Point initBody(final int sizeOfPerson, final List<Point> points, Point point) {
        for (int i = 1; i < sizeOfPerson - 1; i++) {
            point = point.next();
            points.add(point);
        }
        return point;
    }

    private static void initLast(final List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }

    private static Point initFirst(final List<Point> points) {
        Point point = Point.first(generatePoint());
        points.add(point);
        return point;
    }

    @Override
    public String toString() {
        return "LadderLine{" +
                "points=" + points +
                '}';
    }
}
