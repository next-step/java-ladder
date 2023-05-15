package ladder.model;

import ladder.generator.BooleanGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public static Line create(int countOfUser, BooleanGenerator booleanGenerator) {
        List<Point> points = new ArrayList<>();

        Point point = Point.createFirst(booleanGenerator.generate());
        points.add(point);

        for (int i = 1; i < countOfUser - 1; i++) {
            point = point.createNext(booleanGenerator.generate());
            points.add(point);
        }
        points.add(point.createLast());

        return new Line(points);
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public int size() {
        return points.size();
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
