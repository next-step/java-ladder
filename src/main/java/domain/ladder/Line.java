package domain.ladder;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {

    private List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public boolean leftMove(int location) {
        return location <= 0 ? false : points.get(location-1);
    }

    public boolean rightMove(int location) {
        return location >= points.size() ? false : points.get(location);
    }

    public int move(int location) {
        if(leftMove(location)){
            return --location;
        }
        if(rightMove(location)){
            return ++location;
        }
        return location;
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
        return "Line{" +
                "points=" + points +
                '}';
    }
}
