package nextstep.ladder.domain.line;

import nextstep.ladder.exception.ContinousLinePointException;
import nextstep.ladder.exception.OutOfRangeException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Line {

    public static final int MIN_POINT_COUNT = 2;

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

    private void validContinuous(List<Boolean> points) {
        boolean temp = points.get(0);
        for (int i = 1; i < points.size(); i++) {
            if (temp && points.get(i)) {
                throw new ContinousLinePointException();
            }
            temp = points.get(i);
        }
    }

    private void validPointsCount(List<Boolean> points) {
        if (points.size() < MIN_POINT_COUNT) {
            throw OutOfRangeException.shouldGreaterOrEqualThan(MIN_POINT_COUNT, points.size());
        }
    }

    private String parseToDot(boolean value) {
        if (value) {
            return "-----|";
        }
        return "     |";
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
                .map(this::parseToDot)
                .collect(Collectors.joining());
    }
}
