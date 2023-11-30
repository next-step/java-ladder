package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;

public class Line {
    static final String LINE_INDEX_OUT_OF_RANGE_EXCEPTION = "라인의 범위를 넘어섰습니다.";
    public static final String LINE_LENGTH_DIFFERENCE_EXCEPTION = "라인들의 길이가 다릅니다!";
    public static final String HORIZONTAL_LINE_OVERLAPPING_EXCEPTION = "사다리의 수평선이 서로 겹칩니다.";
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

    public void validateSameSizeAs(Line line) {
        if (isSameSize(line)) {
            throw new IllegalStateException(LINE_LENGTH_DIFFERENCE_EXCEPTION);
        }
    }

    private boolean isSameSize(Line line) {
        return this.points.size() != line.points.size();
    }

    public void isOverlapping(Line line) {
        for (int point = 0; point < this.points.size(); point++) {
            validateOverlapping(line, point);
        }
    }

    private void validateOverlapping(Line line, int point) {
        if (isOverlapping(line, point)) {
            throw new IllegalStateException(HORIZONTAL_LINE_OVERLAPPING_EXCEPTION);
        }
    }

    private boolean isOverlapping(Line line, int point) {
        return this.points.get(point) && line.points.get(point);
    }

    public int getMaxHeight() {
        return this.points.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
