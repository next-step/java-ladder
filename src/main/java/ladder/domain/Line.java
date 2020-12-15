package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Line {

    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line ofLineCounts(int numPoints, ConnectionMode mode) {
        List<Point> points = new ArrayList<>();

        Point initialPoint = initFirst(mode, points);
        Point beforeTheLast = initBody(initialPoint, numPoints, mode, points);
        initLast(beforeTheLast, points);

        return new Line(points);
    }

    private static Point initFirst(ConnectionMode mode, List<Point> points) {
        Point first = Point.createFirstFrom(mode.generateConnection());
        points.add(first);

        return first;
    }

    private static Point initBody(Point initialPoint, int numPoints, ConnectionMode mode, List<Point> points) {
        Point currentPoint = initialPoint;

        for (int i = 1; i < numPoints - 1; i++) {
            currentPoint = currentPoint.createNextFrom(mode.generateConnection());
            points.add(currentPoint);
        }

        return currentPoint;
    }

    private static void initLast(Point beforeTheLast, List<Point> points) {
        points.add(beforeTheLast.createLast());
    }

    public List<Point> getValidPoints() {
        return Collections.unmodifiableList(
                IntStream.range(0, points.size() - 1)
                        .mapToObj(points::get)
                        .collect(toList()));
    }

    public int getNextIndex(int index) {
        return points.get(index).nextIndex();
    }
}
