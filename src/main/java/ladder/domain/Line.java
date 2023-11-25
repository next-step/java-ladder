package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Line {

    private final List<Point> points;

    public Line() {
        this(new ArrayList<>());
    }

    public Line(List<Point> points) {
        this.points = points;
    }

    public static Line of(Boolean... values) {
        return new Line(
            Stream.of(values)
                .map(Point::new)
                .collect(Collectors.toList())
        );
    }

    @Override
    public String toString() {
        return " ".repeat(5) + points.stream()
            .map(Point::toString)
            .collect(Collectors.joining());
    }

    public List<Point> getPoints() {
        return points;
    }
}
