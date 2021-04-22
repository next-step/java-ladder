package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Point> points;

    public Line(int numberOfPlayer) {
        points = new ArrayList<>();

        Point point = Point.first();
        points.add(point);

        for (int i = 1; i < numberOfPlayer - 1; i++) {
            point = point.next();
            points.add(point);
        }

        points.add(point.last());
    }

    public Line(List<Link> links) {
        points = new ArrayList<>();
        Point point = Point.first(links.get(0));
        points.add(point);

        for (int i = 1; i < links.size(); i++) {
            point = point.next(links.get(i));
            points.add(point);
        }
        points.add(point.last());
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public List<Point> points() {
        return points;
    }
}
