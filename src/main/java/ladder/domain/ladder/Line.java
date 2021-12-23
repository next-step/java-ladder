package ladder.domain.ladder;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {

    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line createLine(List<Point> points)  {
        return new Line(points);
    }

    public int move(int index) {
        index = points.get(index).move();
        return index;
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        return points + " ";
    }

}
