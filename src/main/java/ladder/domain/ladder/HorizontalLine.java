package ladder.domain.ladder;

import java.util.List;
import java.util.Objects;

public class HorizontalLine {

    private final List<Point> points;

    HorizontalLine(List<Point> points) {
        this.points = points;
    }

    int move(int index) {
        return points.get(index).move();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HorizontalLine that = (HorizontalLine) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
