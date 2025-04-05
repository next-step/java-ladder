package ladder.domain;

import java.util.List;
import java.util.Objects;

public class Line {
    private final Points points;

    public Line(List<Point> points) {
        this.points = new Points(points);
    }

    public Line(int size, ConnectStrategy connectStrategy) {
        this.points = new Points(size, connectStrategy);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(points);
    }
}
