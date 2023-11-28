package ladder.domain;

import java.util.*;
import java.util.stream.Collectors;

import static ladder.domain.Name.NAME_SIZE;

public class Line {

    private final List<Point> points;

    public Line(String strings) {
        this(Arrays.stream(strings.split(""))
            .map(Direction::valueOfCharacter)
            .map(Point::new)
            .collect(Collectors.toList())
        );
    }

    public Line(List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    @Override
    public String toString() {
        return " ".repeat(NAME_SIZE) + points.stream()
            .map(Point::toString)
            .collect(Collectors.joining());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Line line = (Line) object;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return points != null ? points.hashCode() : 0;
    }
}
