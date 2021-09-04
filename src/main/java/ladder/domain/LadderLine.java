package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LadderLine {

    private final List<Point> points;

    private LadderLine(List<Point> points) {
        this.points = points;
    }

    public static LadderLine create(Width width) {
        List<Point> points = new ArrayList<>();
        Point point = start(points);
        point = body(width.getLength(), points, point);
        initEnd(points, point);
        return new LadderLine(points);
    }

    public static LadderLine create(Point... points) {
        return new LadderLine(Arrays.asList(points));
    }

    public int move(int index) {
        return points.get(index).move();
    }

    public List<Point> getPoints() {
        return points;
    }

    private static Point start(List<Point> points) {
        Point point = Point.start(Direction.start(LadderLine::right));
        points.add(point);
        return point;
    }

    private static Point body(int width, List<Point> points, Point point) {
        for (int i = 1; i < width - 1; i++) {
            point = point.next();
            points.add(point);
        }
        return point;
    }

    private static void initEnd(List<Point> points, Point point) {
        points.add(point.end());
    }

    private static boolean right() {
        return Math.random() < 0.5;
    }
}
