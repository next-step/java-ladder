package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;

public class Line {

    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }

    public int move(int position) {
        Point point = points.get(position);
        Direction direction = point.move();
        return position + direction.getDirectionValue();
    }

    @Override
    public String toString() {
        return LinePrinter.convertLineToString(this);
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
