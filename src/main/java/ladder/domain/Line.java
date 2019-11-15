package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Point> points = new ArrayList<>();

    public Line(List<Point> points) {
        this.points = points;
    }

    public List<Point> getPoints() {
        return new ArrayList<>(points);
    }
}
