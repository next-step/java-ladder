package nextstep.ladder.model;

import nextstep.common.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public final class Line {

    private final List<Point> points;

    private Line(List<Point> points) {
        Assert.notEmpty(points, "points must not be empty");
        validatePoints(points);
        this.points = new ArrayList<>(points);
    }

    static Line from(List<Point> points) {
        return new Line(points);
    }

    public List<Point> points() {
        return Collections.unmodifiableList(points);
    }

    private void validatePoints(List<Point> points) {
        Iterator<Point> iterator = points.iterator();
        Point previousPoint = iterator.next();
        while (iterator.hasNext()) {
            Point currentPoint = iterator.next();
            validateOverlap(points, previousPoint, currentPoint);
            previousPoint = currentPoint;
        }
    }

    private void validateOverlap(List<Point> points, Point previousPoint, Point point) {
        if (previousPoint.isConnected() && point.isConnected()) {
            throw new IllegalArgumentException(String.format("pointers(%s) must not be connected continuously", points));
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
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
}
