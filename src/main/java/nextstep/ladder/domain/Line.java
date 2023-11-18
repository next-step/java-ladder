package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;

public class Line {
    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public List<Point> getAll() {
        return this.points;
    }

    public Direction nextDirection(int point) {
        Point currentPoint = this.points.get(point);
        return currentPoint.move();
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
