package nextstep.ladder.domain.line;

import nextstep.ladder.exception.ContinousLinePointException;
import nextstep.ladder.exception.OutOfRangeException;
import nextstep.ladder.view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Line {

    private static final int MIN_POINT_COUNT = 2;

    private List<Boolean> points = new ArrayList<>();

    private Line() {

    }

    private Line(List<Boolean> points) {
        validPointsCount(points);
        validContinuous(points);

        this.points = points;
    }

    public static Line from(Boolean... existPoints) {
        return new Line(
                Arrays.stream(existPoints)
                        .collect(Collectors.toList()));
    }

    public static Line from(List<Boolean> existPoints) {
        return new Line(existPoints);
    }

    public boolean isExistPoint(int index) {
        if (points.size() <= index) {
            return false;
        }
        return points.get(index);
    }

    private void validContinuous(List<Boolean> points) {
        for (int i = 0; i < points.size() - 1; i++) {
            if (points.get(i) && points.get(i + 1)) {
                throw new ContinousLinePointException();
            }
        }
    }

    private void validPointsCount(List<Boolean> points) {
        if (points.size() < MIN_POINT_COUNT) {
            throw OutOfRangeException.shouldGreaterOrEqualThan(MIN_POINT_COUNT, points.size());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        return points.stream()
                .map(ResultView::parseBooleanToDot)
                .collect(Collectors.joining());
    }
}
