package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Line {

    private List<Boolean> points = new ArrayList<>();

    private Line() {

    }

    private Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line from(Boolean... existPoint) {
        return new Line(
                Arrays.stream(existPoint)
                        .collect(Collectors.toList()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
