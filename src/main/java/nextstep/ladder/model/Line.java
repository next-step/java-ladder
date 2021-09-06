package nextstep.ladder.model;

import java.util.Collections;
import java.util.List;

public class Line {
    private List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public int move(int y) {
        Point point = points.get(y);

        return point.move();
    }
}
