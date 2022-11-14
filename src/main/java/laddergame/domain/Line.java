package laddergame.domain;

import laddergame.exception.ErrorCode;
import laddergame.exception.LadderGameException;
import laddergame.util.ValueGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Line {
    private final List<Point> points;

    public Line(List<Point> points) {
        validateContinuous(points);
        this.points = points;
    }

    public Line(Boolean... inputs) {
        this(Arrays.stream(inputs)
                .map(Point::valueOf)
                .collect(Collectors.toList()));
    }

    public static Line create(Width width, ValueGenerator valueGenerator) {
        List<Point> points = new ArrayList<>();
        Point previous = Point.valueOf(false);
        Count count = new Count(0);
        while (width.bigger(count)) {
            Point now = previous.next(valueGenerator);
            points.add(now);
            previous = now;
            count.plus();
        }
        return new Line(points);
    }

    private void validateContinuous(List<Point> points) {
        for (int i = 1; i < points.size(); i++) {
            comparePreviousState(points.get(i - 1), points.get(i));
        }
    }

    private void comparePreviousState(Point previous, Point now) {
        if (previous.isExist() && now.isExist()) {
            throw new LadderGameException(ErrorCode.LADDER_LINE_EXIT_CONTINOUSLY);
        }
    }

    public List<Point> getStates() {
        return this.points;
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
        return "Row{" +
                "states=" + points +
                '}';
    }
}
