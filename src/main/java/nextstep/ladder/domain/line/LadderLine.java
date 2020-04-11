package nextstep.ladder.domain.line;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LadderLine implements Iterable<Point> {
    private final List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public static LadderLine of(int width) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points);
        point = initBody(width, points, point);
        initLast(points, point);
        return new LadderLine(points);
    }

    private static Point initBody(int width, List<Point> points,
                                  Point point) {
        for (int i = 1; i < width - 1; i++) {
            point = point.next();
            points.add(point);
        }
        return point;
    }

    private static void initLast(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }

    private static Point initFirst(List<Point> points) {
        Point point = Point.first();
        points.add(point);
        return point;
    }

    @Override
    public String toString() {
        return "LadderLine{" +
                "points=" + points +
                '}';
    }

    @Override public Iterator<Point> iterator() {
        return points.iterator();
    }
}