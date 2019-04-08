package ladder.domain.ladder;

import ladder.vo.Length;
import ladder.vo.coordinate.Coordinate;

import java.util.List;

public class Line {
    private static final int MIN_POINTS_SIZE = 2;
    private static final int FIRST_INDEX = 0;

    private final List<Point> points;

    public Line(List<Point> points) {
        validatePoints(points);

        this.points = points;
    }

    private void validatePoints(List<Point> points) {
        validatePointsSize(points);
        validateLeftmostPoint(points);
        validateRightmostPoint(points);
        validateCrossOfPoints(points);
    }

    private void validatePointsSize(List<Point> points) {
        if (points.size() < MIN_POINTS_SIZE) {
            throw new IllegalArgumentException("Min points size is " + MIN_POINTS_SIZE);
        }
    }

    private void validateLeftmostPoint(List<Point> points) {
        Point leftmostPoint = points.get(FIRST_INDEX);

        if (leftmostPoint.canCrossLeft()) {
            throw new IllegalArgumentException("The leftmost point can't cross left");
        }
    }

    private void validateRightmostPoint(List<Point> points) {
        int lastIndex = points.size() - 1;
        Point rightmostPoint = points.get(lastIndex);

        if (rightmostPoint.canCrossRight()) {
            throw new IllegalArgumentException("The rightmost point can't cross right");
        }
    }

    private void validateCrossOfPoints(List<Point> points) {
        for (int i = 0, pointsSizeMinusOne = points.size() - 1; i < pointsSizeMinusOne; i++) {
            Point currentPoint = points.get(i);
            Point nextPoint = points.get(i + 1);
            validateCrossOfPoints(currentPoint, nextPoint);
        }
    }

    private void validateCrossOfPoints(Point currentPoint, Point nextPoint) {
        if (currentPoint.canCrossRight() != nextPoint.canCrossLeft()) {
            throw new IllegalArgumentException();
        }
    }

    public Length getWidth() {
        int width = this.points.size() - 1;
        return new Length(width);
    }

    Coordinate cross(Coordinate coordinate) {
        Point point = this.points.get(coordinate.getXValue());

        if (point.canCrossLeft()) {
            return coordinate.left();
        }

        if (point.canCrossRight()) {
            return coordinate.right();
        }

        return coordinate;
    }
}
