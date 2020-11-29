package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {

    private final List<Boolean> points;

    public Line (List<Boolean> points) {
        this.points = points;
    }

    public boolean hasRightMoved(int index) {
        if(index == (points.size()-1)) {
            return false;
        }
        return points.get(index);
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
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
