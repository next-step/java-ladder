package nextstep.ladder.domain;

import java.util.Objects;

public class Line {

    private final LineRange lineRange;
    private boolean hasPoint;

    public Line(boolean hasPoint, int left) {
        this(hasPoint, new LineRange(left));
    }

    public Line(boolean hasPoint, LineRange lineRange) {
        this.hasPoint = hasPoint;
        this.lineRange = lineRange;
    }

    public void move(Position position) {
        if (hasPoint) {
            lineRange.swap(position);
        }
    }

    public boolean canMove() {
        return hasPoint;
    }

    public boolean connected(Line line) {
        if (hasNoConsecutivePoints(line)) {
            return false;
        }
        return lineRange.isContinue(line.lineRange);
    }

    private boolean hasNoConsecutivePoints(Line line) {
        return !hasPoint || !line.hasPoint;
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
