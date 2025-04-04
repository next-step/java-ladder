package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line generate(int ladderWidth, PointGetStrategy pointGetStrategy) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < ladderWidth; i++) {
            if (i != 0 && points.get(i - 1) == Point.RIGHT) {
                points.add(Point.LEFT);
                continue;
            }
            points.add(Point.get(pointGetStrategy));
        }
        return new Line(points);
    }

    public List<Point> getPoints() {
        return points;
    }
}
