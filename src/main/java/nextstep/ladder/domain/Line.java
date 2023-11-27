package nextstep.ladder.domain;

import java.util.List;

public class Line {
    static final String LINE_INDEX_OUT_OF_RANGE_EXCEPTION = "라인의 범위를 넘어섰습니다.";
    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public boolean hasHorizontalLine(int point) {
        validateLineRange(point);
        return points.get(point);
    }

    private void validateLineRange(int point) {
        if (outOfRange(point)) {
            throw new ArrayIndexOutOfBoundsException(LINE_INDEX_OUT_OF_RANGE_EXCEPTION);
        }
    }

    private boolean outOfRange(int point) {
        return point >= points.size();
    }
}
