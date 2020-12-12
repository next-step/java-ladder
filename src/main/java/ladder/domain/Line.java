package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Line {

    private final List<Point> points;

    public static Line ofLineCounts(int numPoints, ConnectionMode mode) {
        List<Point> points = new ArrayList<>();

        Point currentPoint = Point.first(mode.generateConnection());
        points.add(currentPoint);

        for (int i = 1; i < numPoints - 1; i++) {
            currentPoint = currentPoint.next(mode.generateConnection());
            points.add(currentPoint);
        }

        Point lastPoint = currentPoint.last();
        points.add(lastPoint);

        return new Line(points);
    }

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line ofPoints(List<Point> points) {
        return new Line(points);
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
