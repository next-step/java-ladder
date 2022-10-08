package ladder.domain;

import java.util.List;

public class Line {
    private final List<Boolean> horizontalWays;

    public Line(List<Boolean> horizontalWays) {
        this.horizontalWays = horizontalWays;
    }

    public List<Boolean> horizontalWays() {
        return horizontalWays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        return horizontalWays.equals(line.horizontalWays);
    }

    @Override
    public int hashCode() {
        return horizontalWays.hashCode();
    }
}
