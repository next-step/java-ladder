package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public Line(int size, ConnectStrategy connectStrategy) {
        this.points = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.points.add(connectStrategy.connect(i));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(points);
    }
}
