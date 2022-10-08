package ladder.domain;

import java.util.List;

public class Line {
    private final List<Boolean> lanes;

    public Line(List<Boolean> lanes) {
        this.lanes = lanes;
    }

    public List<Boolean> lanes() {
        return lanes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        return lanes.equals(line.lanes);
    }

    @Override
    public int hashCode() {
        return lanes.hashCode();
    }
}
