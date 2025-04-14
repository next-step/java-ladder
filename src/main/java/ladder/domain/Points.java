package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Points {
    private final List<Point> points = new ArrayList<>();

    public void add(Point point) {
        points.add(point);
    }

    public Point get(int idx) {
        return points.get(idx);
    }

    public List<Point> getPoints() {
        return List.copyOf(points);
    }
}
