package nextstep.ladder.domain;

import java.util.Map;
import java.util.Objects;

public class Line {

    private final LineRange lineRange;
    private boolean hasPoint;

    public Line(boolean hasPoint, int left) {
        this.hasPoint = hasPoint;
        this.lineRange = new LineRange(left);
    }

    public void move(Map<Integer, Integer> map) {
        if (hasPoint) {
            lineRange.swap(map);
        }
    }

    public boolean canMove() {
        return hasPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Line point = (Line) o;
        return hasPoint == point.hasPoint && Objects.equals(lineRange, point.lineRange);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineRange, hasPoint);
    }
}
