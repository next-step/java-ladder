package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class HorizontalLine {

    private final List<Point> points;

    public HorizontalLine(List<Point> points) {
        this.points = points;
    }

    public HorizontalLine(Boolean... points) {
        this(Arrays.stream(points).map(Point::new).collect(Collectors.toList()));

    }

    public List<Point> points() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof HorizontalLine)) {
            return false;
        }
        HorizontalLine that = (HorizontalLine) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
