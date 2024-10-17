package ladder;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Line {

    private final List<Boolean> points;

    public Line(Boolean... points) {
        this(Arrays.stream(points).collect(Collectors.toList()));
    }

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public Line(int ladderSize, LineGenerator lineGenerator) {
        this.points = lineGenerator.run(ladderSize);
    }

    public List<Boolean> getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Line))
            return false;
        Line line = (Line)o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(points);
    }
}
