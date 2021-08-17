package ladder.domain.ladder;

import java.util.List;
import java.util.stream.Collectors;

public class Line {

    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line of(List<Point> points) {
        return new Line(points);
    }

    public List<Boolean> toBooleans() {
        return points.stream()
                .map(Point::value)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}
