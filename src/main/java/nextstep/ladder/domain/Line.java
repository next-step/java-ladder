package nextstep.ladder.domain;

import nextstep.ladder.strategy.PointStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Line {
    private static final int FIRST_POINT_POSITION = 0;

    private final List<Point> points;

    private Line(List<Point> points) {
        validateLine(points);
        this.points = points;
    }

    public static Line of(int countOfMember, PointStrategy pointStrategy) {
        return new Line(getPoints(countOfMember, pointStrategy));
    }

    public static Line createWithVariables(Boolean... points) {
        return new Line(toLine(points));
    }

    private void validateLine(List<Point> points) {
        for (int count = FIRST_POINT_POSITION; count < points.size(); count++) {
            if (count == FIRST_POINT_POSITION && points.get(count).isLine()) {
                throw new IllegalArgumentException("");
            }
            if (count > FIRST_POINT_POSITION && points.get(count).isLine()
                                                && points.get(count-1).isLine()) {
                throw new IllegalArgumentException("");
            }
        }
    }

    private static List<Point> getPoints(int countOfMember, PointStrategy pointStrategy) {
        List<Point> pointGroup = new ArrayList<>();
        for (int count = FIRST_POINT_POSITION; count < countOfMember; count++) {
            pointGroup.add(generatePoint(pointStrategy, pointGroup, count));
        }
        return pointGroup;
    }

    private static Point generatePoint(PointStrategy pointStrategy, List<Point> pointGroup, int count) {
        if (count == FIRST_POINT_POSITION || pointGroup.get(count-1).isLine()) {
            return new Point(false);
        }
        return new Point(pointStrategy.generate());
    }

    private static List<Point> toLine(Boolean[] points) {
        return Arrays.stream(points)
                            .map(Point::new)
                            .collect(Collectors.toList());
    }

    public boolean isLine(int count) {
        return points.get(count).isLine();
    }

    public boolean isNextLine(int count) {
        int maxCount = count + 1;
        if (maxCount == points.size()) {
            return false;
        }
        return points.get(maxCount).isLine();
    }

    public List<Point> getPoints() {
        return points;
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
}
