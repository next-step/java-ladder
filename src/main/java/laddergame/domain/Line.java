package laddergame.domain;

import java.util.List;
import java.util.Objects;
import laddergame.utils.Validation;

public class Line {

    private List<Boolean> points;

    public Line(int countOfPeople, LineStrategy lineStrategy) {
        Validation.countOfParticipants(countOfPeople);
        int initialCapacity = countOfPeople - 1;
        init(lineStrategy, initialCapacity);
    }

    private void init(final LineStrategy lineStrategy, final int initialCapacity) {
        this.points = lineStrategy.getLine(initialCapacity);
    }

    public List<Boolean> getPoints() {
        return points;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
