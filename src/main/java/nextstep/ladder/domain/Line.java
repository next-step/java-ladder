package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {

    private final List<Boolean> points;

    public Line(int countOfPerson, LineGenerator generator) {
        points = new ArrayList<>();
        points.add(generator.generate());
        for (int i = 1; i < countOfPerson-1; i++) {
            if (prevIsTrue(i)) {
                points.add(false);
                continue;
            }
            points.add(generator.generate());
        }
    }

    private boolean prevIsTrue(int i) {
        return points.get(i - 1);
    }

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public List<Boolean> getPoints() {
        return points;
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
