package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;

public class Line {

    private List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public Point getPoint(int index) {
        return points.get(index);
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
