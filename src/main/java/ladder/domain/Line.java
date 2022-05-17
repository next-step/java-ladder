package ladder.domain;

import ladder.constant.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {

    private final List<Point> points = new ArrayList<>();

    public Line(List<Point> points) {
        for (int i = 0; i < points.size(); i++) {
            if (i != 0 && this.points.get(i - 1).isConnect()) {
                this.points.add(Point.DISCONNECTED);
                continue;
            }
            this.points.add(points.get(i));
        }
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

    @Override
    public String toString() {
        return this.points.toString();
    }
}

