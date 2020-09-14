package ladder.refactoring.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {

    private final List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public static LadderLine of(int size) {
        List<Point> points = initPoints(size);
        return new LadderLine(points);
    }

    private static List<Point> initPoints(int size) {
        List<Point> points = new ArrayList<>();
        Point point = Point.ofFirstPoint();

        points.add(point);
        while (points.size() < size - 1) {
            point = point.next();
            points.add(point);
        }
        points.add(point.last());
        return points;
    }

    public List<Point> getPoints() {
        return points;
    }

    public int move(int position) {
        return points.get(position).move();
    }
}
