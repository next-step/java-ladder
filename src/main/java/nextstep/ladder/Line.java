package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public static Line of(int countOfPerson) {
        List<Point> points = new ArrayList<>();
        Point point = new Point();
        points.add(0, point);

        for (int idx = 1; idx < countOfPerson - 1; idx++) {
            Point nextPoint = point.nextPoint();
            points.add(nextPoint);
            point = nextPoint;
        }

        return new Line(points);
    }

    public List<Point> points() {
        return new ArrayList<>(points);
    }
}