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

    public Line(int countOfMember, PointStrategy pointStrategy) {
        this(getPoints(countOfMember, pointStrategy));
    }

    public Line(Boolean... points) {
        this(toLine(points));
    }

    public Line(List<Point> points) {
        this.points = points;
    }

    private static List<Point> getPoints(int countOfMember, PointStrategy pointStrategy) {
        List<Point> pointGroup = new ArrayList<>();
        for (int count = FIRST_POINT_POSITION; count < countOfMember; count++) {
            if (count == FIRST_POINT_POSITION) {
                pointGroup.add(new Point(false));
            } else if (pointGroup.get(count-1).equals(new Point(true))) {
                pointGroup.add(new Point(false));
            } else {
                pointGroup.add(new Point(pointStrategy.generate()));
            }
        }
        return pointGroup;
    }

    private static List<Point> toLine(Boolean[] points) {
        return Arrays.stream(points)
                            .map(point -> new Point(point))
                            .collect(Collectors.toList());
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
