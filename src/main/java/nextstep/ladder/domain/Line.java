package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;

public class Line {
    private List<Boolean> points;

    public Line(List<Boolean> points) {
        validation(points);
        this.points = points;
    }

    private void validation(List<Boolean> points) {
        boolean prevPoint = false;
        for (boolean point : points) {
            if (prevPoint && point) {
                throw new IllegalArgumentException("사다리를 만들 수 없습니다.");
            }
            prevPoint = point;
        }
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
