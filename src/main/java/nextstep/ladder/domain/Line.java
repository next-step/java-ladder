package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {

    private List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public Line() {
        this(new ArrayList<>());
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

    public boolean hasLineAtPosition(int position) {
        return points.get(position);
    }
}
