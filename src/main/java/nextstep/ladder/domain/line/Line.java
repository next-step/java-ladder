package nextstep.ladder.domain.line;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Line {
    private final List<Point> value;

    public Line(List<Point> points) {
        this.value = points;
    }

    public List<Boolean> getValue() {
        return value.stream().map(Point::getValue).collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(value, line.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "Line{" +
            "value=" + value +
            '}';
    }
}
