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
    private final LineStrategy lineStrategy;

    public Line(List<Point> points, LineStrategy lineStrategy) {
        this.points = points;
        this.lineStrategy = lineStrategy;
    }

    public static Line of(List<Point> points, LineStrategy lineStrategy) {
        return new Line(points, lineStrategy);
    }

    public Line(int users, LineStrategy lineStrategy) {
        if (users < MINIMUM) {
            throw new IllegalArgumentException();
        }
        this.lineStrategy = lineStrategy;
        this.points = createBy(users);
    }

    private List<Point> createBy(int users) {
        List<Point> points = new ArrayList<>();
        points.add(Point.init(lineStrategy.random()));
        for (int i = BASE; i < users; i++) {
            Point point = points.get(i - BASE);
            add(points, point, i == users - 1);
        }
        return points;
    }

    public List<Point> getPoints() {
        return points;
    }

    private void add(List<Point> points, Point point, boolean last) {
        if (last) {
            points.add(point.end());
            return;
        }
        boolean nextBoolean = getNextBoolean(point.isCurrent());
        points.add(point.next(nextBoolean));
    }

    private boolean getNextBoolean(boolean current) {
        if (current) {
            return false;
        }
        return lineStrategy.random();
    }
}
