package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private List<Point> points = new ArrayList<>();

    public Line(List<Point> points) {
        this.points = points;
    }

    public List<Point> getPoints() {
        return new ArrayList<>(points);
    }

    public List<Boolean> types() {
        return points.stream()
                .map(Point::getType)
                .collect(Collectors.toList());
    }
}
