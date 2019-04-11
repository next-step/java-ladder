package ladder.domain.ladder;

import ladder.domain.ladder.generator.DirectionGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line2 {
    private static final int MIN_SIZE = 2;

    private final List<Point2> points;

    public Line2(List<Point2> points) {
        validatePoints(points);

        this.points = points;
    }

    public static Line2 init(int size, DirectionGenerator directionGenerator) {
        validateSize(size);

        List<Point2> points = new ArrayList<>(size);

        Point2 point = Point2.first(directionGenerator.generate());
        points.add(point);

        for (int i = 0; i < size - 2; i++) {
            point = point.next(directionGenerator.generate());
            points.add(point);
        }

        points.add(point.last());

        return new Line2(points);
    }

    int getSize() {
        return this.points.size();
    }

    private void validatePoints(List<Point2> points) {
        validateSize(points.size());
        validateFirstPoint(points.get(0));
        validateLastPoint(points.get(points.size() - 1));

        int pointsSizeMinusOne = points.size() - 1;
        for (int i = 0; i < pointsSizeMinusOne; i++) {
            Point2 previous = points.get(i);
            Point2 current = points.get(i + 1);

            validatePoints(previous, current);
        }
    }

    private void validateFirstPoint(Point2 firstPoint) {
        if (firstPoint.canMoveLeft()) {
            throw new IllegalArgumentException("You can't move left at first point");
        }
    }

    private void validateLastPoint(Point2 lastPoint) {
        if (lastPoint.canMoveRight()) {
            throw new IllegalArgumentException("You can't move right at last point");
        }
    }

    private void validatePoints(Point2 previous, Point2 current) {
        if (previous.canMoveRight() != current.canMoveLeft()) {
            throw new IllegalStateException("Points aren't engaged");
        }
    }

    private static void validateSize(int size) {
        if (size < MIN_SIZE) {
            throw new IllegalArgumentException("Line size must be at least " + MIN_SIZE);
        }
    }
}
