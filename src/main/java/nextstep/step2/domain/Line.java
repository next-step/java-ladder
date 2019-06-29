package nextstep.step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public static Line create(final int playerCount) {
        List<Point> points = new ArrayList<>();
        points.add(new Point());
        for (int i = 1; i < playerCount - 1; i++) {
            points.add(Point.create(points.get(i - 1)));
        }
        return new Line(points);
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "Line : " + points;
    }
}
