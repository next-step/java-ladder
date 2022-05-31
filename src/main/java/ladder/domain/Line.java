package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Point> points;

    Line(List<Point> points) {
        this.points = points;
    }

    static Line of(int size) {
        List<Point> points = new ArrayList<>();

        points.add(new Point());
        for (int i = 1; i < size; i++) {
            points.add(points.get(i - 1).nextPoint());
        }

        return new Line(points);
    }

    public List<Point> getPoints() {
        return points;
    }
}
