package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Line {

    static final String LINE_INDEX_OUT_OF_RANGE_EXCEPTION = "라인의 범위를 넘어섰습니다.";
    public static final String LINE_LENGTH_DIFFERENCE_EXCEPTION = "라인들의 길이가 다릅니다!";
    public static final String HORIZONTAL_LINE_OVERLAPPING_EXCEPTION = "사다리의 수평선이 서로 겹칩니다.";
    public static final String NO_LINE_TO_COMPARE_SIZE_EXCEPTION = "사이즈를 비교할 라인이 존재하지 않습니다.";
    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line createLine2WithPoints(List<Point> points) {
        return new Line(points);
    }

    public static Line createLine2WithPointStatus(List<Boolean> pointStatus) {
        return new Line(createPoints(pointStatus));
    }

    private static List<Point> createPoints(List<Boolean> pointStatus) {
        return pointStatus.stream().map(Point::valueOf).collect(Collectors.toList());
    }

    public Point horizontalLine(int point) {
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
        return Optional.ofNullable(line)
                .map(l -> this.points.size() != l.points.size())
                .orElseThrow(() -> new NullPointerException(NO_LINE_TO_COMPARE_SIZE_EXCEPTION));
    }

    public void isOverlapping(Line line) {
        int bound = this.points.size();
        for (int point = 0; point < bound; point++) {
            validateOverlapping(line, point);
        }
    }

    private void validateOverlapping(Line line, int point) {
        if (isOverlapping(line, point)) {
            throw new IllegalStateException(HORIZONTAL_LINE_OVERLAPPING_EXCEPTION);
        }
    }

    private boolean isOverlapping(Line otherLine, int pointIndex) {
        return getPoint(pointIndex).isOverlapping(otherLine.getPoint(pointIndex));
    }

    private Point getPoint(int point) {
        return this.points.get(point);
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
