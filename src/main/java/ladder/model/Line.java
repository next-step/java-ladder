package ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    public static final int MINIMUM_NUMBER_OF_POINTS = 2;
    private static final String MESSAGE_OF_MINIMUM_POINTS_EXCEPTION = "Line의 Point 갯수는 최소 %d 이상이어야 합니다.";

    private final List<Point> points;

    public Line(int numberOfPoints) {
        checkNumberOfPoints(numberOfPoints);
        points = Collections.unmodifiableList(generatePoints(numberOfPoints));
    }

    private static void checkNumberOfPoints(int numberOfPoints) {
        if (numberOfPoints < MINIMUM_NUMBER_OF_POINTS) {
            throw new IllegalArgumentException(
                    String.format(MESSAGE_OF_MINIMUM_POINTS_EXCEPTION, MINIMUM_NUMBER_OF_POINTS));
        }
    }

    private static List<Point> generatePoints(int numberOfPoints) {
        final List<Point> points = new ArrayList<>();

        addFirstPoint(points);
        addMidPoints(points, numberOfPoints);
        addEndPoint(points);

        return points;
    }

    private static void addFirstPoint(List<Point> points) {
        final Point first = Point.firstOfRandom();
        points.add(first);
    }

    private static void addMidPoints(List<Point> points, int numberOfPoints) {
        IntStream.range(0, numberOfPoints - MINIMUM_NUMBER_OF_POINTS)
                 .mapToObj(i -> points.get(i).nextOfRandom())
                 .forEach(points::add);
    }

    private static void addEndPoint(List<Point> points) {
        final Point lastOfMid = points.get(points.size() - 1);
        final Point end = lastOfMid.endOf();
        points.add(end);
    }

    public List<Point> getPoints() {
        return points;
    }
}
