package ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    public static final int MINIMUM_NUMBER_OF_POINTS = 2;
    private static final String MESSAGE_OF_MINIMUM_POINTS_EXCEPTION = "Line의 Point 갯수는 최소 다음 이상이어야 합니다.: ";

    private final List<Point> points;

    public Line(int numberOfPoints) {
        checkNumberOfPoints(numberOfPoints);
        points = Collections.unmodifiableList(generatePoints(numberOfPoints));
    }

    private static void checkNumberOfPoints(int numberOfPoints) {
        if (numberOfPoints < MINIMUM_NUMBER_OF_POINTS) {
            throw new IllegalArgumentException(String.valueOf(
                    new StringBuilder(MESSAGE_OF_MINIMUM_POINTS_EXCEPTION).append(MINIMUM_NUMBER_OF_POINTS)));
        }
    }

    private static List<Point> generatePoints(int numberOfPoints) {
        final List<Point> points = new ArrayList<>();

        final Point first = addFirstPoint(points);
        final Point lastOfMid = addMidPoints(points, first, numberOfPoints);
        addEndPoint(points, lastOfMid);

        return points;
    }

    private static Point addFirstPoint(List<Point> points) {
        final Point first = Point.firstOfRandom();
        points.add(first);
        return first;
    }

    private static Point addMidPoints(List<Point> points, Point first, int numberOfPoints) {
        Point next = first;
        for (int i = 0; i < numberOfPoints - MINIMUM_NUMBER_OF_POINTS; i++) {
            next = next.nextOfRandom();
            points.add(next);
        }
        return next;
    }

    private static void addEndPoint(List<Point> points, Point next) {
        final Point end = next.endOf();
        points.add(end);
    }

    public List<Point> getPoints() {
        return points;
    }
}
