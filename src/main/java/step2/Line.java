package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line newLine(int countOfPerson) {
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < countOfPerson - 1; i++) {
            points.add(Point.validPrePoint(points));
        }

        return new Line(points);
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public int size() {
        return points.size();
    }
}
