package ladder.model.point;

import java.util.*;

public class Points {

    private final List<Point> points;

    public Points(List<Point> points) {
        this.points = points;
    }

    public List<Point> get() {
        return Collections.unmodifiableList(points);
    }

    public int move(int idx) {
        return this.points.get(idx).move();
    }
}
