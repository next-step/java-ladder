package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author han
 */
public class Line {
    private static final int MINIMUM = 2;
    private static final int BASE = 1;

    private final List<Point> points;

    public Line(List<Point> points) {
       this.points = points;
    }

    public static Line of (List<Point> points) {
        return new Line(points);
    }

    public Line(int users, LineStrategy lineStrategy) {
        if (users < MINIMUM) {
            throw new IllegalArgumentException();
        }
        this.points = createBy(users, lineStrategy);
    }

    private List<Point> createBy(int users, LineStrategy lineStrategy) {
        List<Point> points = new ArrayList<>();
        points.add(Point.init(lineStrategy.random()));
        for (int i = BASE; i < users; i++) {
            Point point = points.get(i - BASE);
            add(points, point, i == users - 1, lineStrategy);
        }
        return points;
    }

    public List<Point> getPoints() {
        return points;
    }

    private void add(List<Point> points, Point point, boolean last, LineStrategy lineStrategy) {
        if (last) {
            points.add(point.end());
            return;
        }
        points.add(point.next(lineStrategy.random()));
    }
}
