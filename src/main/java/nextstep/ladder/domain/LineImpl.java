package nextstep.ladder.domain;

import java.util.Objects;
import nextstep.ladder.interfaces.Line;
import nextstep.ladder.interfaces.Position;

public class LineImpl implements Line {

    private final LineRange lineRange;
    private boolean hasPoint;

    public LineImpl(boolean hasPoint, int left) {
        this(hasPoint, new LineRange(left));
    }

    public LineImpl(boolean hasPoint, LineRange lineRange) {
        this.hasPoint = hasPoint;
        this.lineRange = lineRange;
    }

    @Override
    public void move(Position position) {
        if (hasPoint) {
            lineRange.swap(position);
        }
    }

    @Override
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
        LineImpl point = (LineImpl) o;
        return hasPoint == point.hasPoint && Objects.equals(lineRange, point.lineRange);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineRange, hasPoint);
    }
}
