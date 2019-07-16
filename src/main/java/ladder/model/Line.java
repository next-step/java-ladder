package ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Line {
    public static final int MINIMUM_NUMBER_OF_POINTS = 2;
    private static final String MESSAGE_OF_MINIMUM_POINTS_EXCEPTION = "Line의 Point 갯수는 최소 %d 이상이어야 합니다.";

    public static Line generateRandom(int numberOfPoints) {
        checkNumberOfPoints(numberOfPoints);
        final List<Point> points = generateRandomPoints(numberOfPoints);
        return new Line(points);
    }

    private final List<Point> points;

    Line(List<Point> points) {
        this.points = Collections.unmodifiableList(points);
    }

    private static void checkNumberOfPoints(int numberOfPoints) {
        if (numberOfPoints < MINIMUM_NUMBER_OF_POINTS) {
            throw new IllegalArgumentException(
                    String.format(MESSAGE_OF_MINIMUM_POINTS_EXCEPTION, MINIMUM_NUMBER_OF_POINTS));
        }
    }

    private static List<Point> generateRandomPoints(int numberOfPoints) {
        final List<Point> points = new ArrayList<>();

        final Point first = addFirstPoint(points);
        final Point lastOfMid = addMidPoints(numberOfPoints, points, first);
        addEndPoint(points, lastOfMid);

        return points;
    }

    private static Point addFirstPoint(List<Point> points) {
        final Point first = Point.firstOf(new RandomConnector());
        points.add(first);
        return first;
    }

    private static Point addMidPoints(int numberOfPoints, List<Point> points, Point point) {
        for (int i = 1; i < numberOfPoints - 1; i++) {
            point = point.nextOf(new RandomConnector());
            points.add(point);
        }
        return point;
    }

    private static void addEndPoint(List<Point> points, Point point) {
        point = point.endOf();
        points.add(point);
    }

    public List<Point> getPoints() {
        return points;
    }

    public int move(int start) {
        final Point point = points.get(start);
        return point.move();
    }
}
