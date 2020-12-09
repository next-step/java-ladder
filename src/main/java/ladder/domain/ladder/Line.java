package ladder.domain.ladder;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {

    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public boolean isAvailableMove(int countOfPerson) {
        return points.get(countOfPerson);
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public int sizeWidth() {
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
        return Objects.hash(points);
    }
}
