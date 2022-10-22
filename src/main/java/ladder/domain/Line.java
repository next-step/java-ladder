package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private final List<Boolean> points;

    public Line (boolean firstPoint) {
        points = new ArrayList<>(List.of(firstPoint));
    }

    public Line (List<Boolean> points) {
        this.points = points;
    }

    public void addPoint(boolean point) {
        points.add(point);
    }

    public boolean isLastPointTrue() {
        return points.get(points.size() - 1);
    }

    public List<Boolean> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return points.toString();
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
