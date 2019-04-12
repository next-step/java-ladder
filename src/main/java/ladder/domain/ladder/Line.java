package ladder.domain.ladder;

import ladder.domain.ladder.generator.DirectionGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private static final int MIN_SIZE = 2;
    private static final String LEFT_PADDING = "    ";

    private final List<Point> points;

    public Line(List<Point> points) {
        validatePoints(points);

        this.points = points;
    }

    public static Line init(int size, DirectionGenerator directionGenerator) {
        validateSize(size);

        List<Point> points = new ArrayList<>(size);
        Point point = Point.first(directionGenerator.generate());

        points.add(point);
        point = makeLineBody(size, point, points, directionGenerator);
        points.add(point.last());

        return new Line(points);
    }

    public int move(int index) {
        return this.points.get(index).move();
    }

    @Override
    public String toString() {
        return LEFT_PADDING + this.points.stream()
                .map(Point::toString)
                .collect(Collectors.joining());
    }


    int getSize() {
        return this.points.size();
    }

    private void validatePoints(List<Point> points) {
        validateSize(points.size());

        Point firstPoint = points.get(0);
        validateFirstPoint(firstPoint);

        Point lastPoint = points.get(points.size() - 1);
        validateLastPoint(lastPoint);

        validatePointDirection(points);
    }

    private void validateFirstPoint(Point firstPoint) {
        if (firstPoint.canMoveLeft()) {
            throw new IllegalArgumentException("You can't move left at first point");
        }
    }

    private void validateLastPoint(Point lastPoint) {
        if (lastPoint.canMoveRight()) {
            throw new IllegalArgumentException("You can't move right at last point");
        }
    }

    private void validatePointDirection(List<Point> points) {
        int pointsSizeMinusOne = points.size() - 1;
        for (int i = 0; i < pointsSizeMinusOne; i++) {
            Point previous = points.get(i);
            Point current = points.get(i + 1);

            validatePointPointDirection(previous, current);
        }
    }

    private void validatePointPointDirection(Point previous, Point current) {
        if (previous.canMoveRight() != current.canMoveLeft()) {
            throw new IllegalStateException("Points aren't engaged");
        }
    }

    private static void validateSize(int size) {
        if (size < MIN_SIZE) {
            throw new IllegalArgumentException("Line size must be at least " + MIN_SIZE);
        }
    }

    private static Point makeLineBody(int size, Point point, List<Point> points, DirectionGenerator directionGenerator) {
        int bodySize = size - MIN_SIZE;

        for (int i = 0; i < bodySize; i++) {
            point = point.next(directionGenerator.generate());
            points.add(point);
        }

        return point;
    }
}
