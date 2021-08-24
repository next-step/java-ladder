package ladder.domain;

import ladder.strategy.PointStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {

    private List<Boolean> points;

    public Line(int countOfPerson) {
        points = new ArrayList<>();
        points.add(false);

        for (int i = 1; i < countOfPerson; i++) {
            points.add(PointStrategy.generate(points.get(i - 1)));
        }
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