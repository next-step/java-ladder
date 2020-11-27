package step2.domain;

import java.util.List;
import java.util.Objects;

import static java.util.Collections.unmodifiableList;

public class Line {
    private final List<Boolean> points;

    private Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line of(final int personCount, LineStrategy lineStrategy) {
        return new Line(lineStrategy.createLine(personCount));
    }

    public List<Boolean> getPoints() {
        return unmodifiableList(points);
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
