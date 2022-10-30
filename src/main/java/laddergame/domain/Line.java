package laddergame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Point> points;

    public Line(List<Point> values) {
        this.points = values;
    }

    public static Line of(int numberOfPerson) {

        List<Point> points = new ArrayList<>();
        Point point = Point.first();
        points.add(point);

        for (int i = 1; i < numberOfPerson-1; i++) {
            point = point.next();
            points.add(point);
        }

        points.add(point.last());
        return new Line(points);
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public int nextIndex(int index) {
        return points.get(index).move();
    }
}
