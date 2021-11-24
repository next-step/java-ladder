package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import static nextstep.ladder.utils.Validator.checkNotNull;

public class Line {

    public static final String NOT_POSITIVE_ERROR_MESSAGE = "너비는 양수여야 합니다.";
    private static final int MIN_WIDTH = 1;
    private static final int EDGE_WIDTH = 1;
    private static final int INTERVAL = 1;
    private static final boolean DEFAULT_POINT = false;

    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        checkPositiveSize(points);
        this.points = points;
    }

    private void checkPositiveSize(List<Boolean> points) {
        if (points == null || points.size() < MIN_WIDTH) {
            throw new IllegalArgumentException(NOT_POSITIVE_ERROR_MESSAGE);
        }
    }

    public static Line of(int width, PointRule pointRule) {
        checkArguments(width, pointRule);

        List<Boolean> edgedPoints = new ArrayList<>(Collections.nCopies(width + EDGE_WIDTH * 2, DEFAULT_POINT));
        IntStream.rangeClosed(EDGE_WIDTH, width)
                .filter(index -> pointRule.canCreate())
                .filter(index -> isSideEmpty(edgedPoints, index))
                .forEach(index -> createPoint(edgedPoints, index));
        return new Line(edgedPoints.subList(EDGE_WIDTH, width + EDGE_WIDTH));
    }

    private static void checkArguments(int width, PointRule pointRule) {
        checkPositiveWidth(width);
        checkNotNull(pointRule);
    }

    private static boolean isSideEmpty(List<Boolean> points, int index) {
        return !(points.get(index - INTERVAL) || points.get(index + INTERVAL));
    }
    private static void createPoint(List<Boolean> points, int index) {
        points.set(index, true);
    }

    private static void checkPositiveWidth(int width) {
        if (width < MIN_WIDTH) {
            throw new IllegalArgumentException(NOT_POSITIVE_ERROR_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }

}
