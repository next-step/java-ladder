package step2.model;

import java.util.List;
import java.util.Objects;

public class Line {
    private final Points points;

    public Line(int numberOfUser, ValueStrategy valueStrategy) {
        points = new Points(numberOfUser, valueStrategy);
    }

    public Line(Points points) {
        this.points = points;
    }

    public List<Boolean> getLine() {
        return points.getPoints();
    }

    public int changeIndex(int index) {
        return points.changeIndex(index);
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
