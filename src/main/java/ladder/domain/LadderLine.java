package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LadderLine {
    private final List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = Collections.unmodifiableList(new ArrayList<>(points));
    }

    public Position move(Position currentPosition) {
        return points.get(currentPosition.toInt()).move();
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderLine)) return false;
        LadderLine line = (LadderLine) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
