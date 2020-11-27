package step2.domain;

import java.util.List;

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
}
