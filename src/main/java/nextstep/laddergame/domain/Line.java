package nextstep.laddergame.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Line {
    private List<Point> points;
    public Line(int length) {

        Point point = Point.createFirst();
        List<Point> points = new ArrayList<>();
        points.add(point);
        for (int index = 1; index < length - 1; index++) {
            point = Point.createWithBeforePoint(point);
            points.add(point);
        }
        points.add(Point.createLastWithBeforePoint(point));
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }
}
