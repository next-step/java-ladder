package net.chandol.ladder.v2.domain.line;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Line {
    private List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public boolean hasPoint(int row) {
        return points.get(row);
    }

    public static Line of(Boolean... points) {
        return new Line(Arrays.asList(points));
    }

    public int height() {
        return points.size();
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
        return points != null ? points.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Line{" + "points=" + points + '}';
    }
}
