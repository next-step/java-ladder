package ladder.structure.connection.result;

import ladder.structure.connection.ConnectionStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Points {
    private final List<Point> points;

    public Points(int ladderWidth, ConnectionStrategy connectionStrategy) {
        this.points = IntStream.rangeClosed(0, ladderWidth).boxed()
                .map(Point::of)
                .collect(toList());
        setDirections(connectionStrategy);
    }

    private Points(List<Point> points, ConnectionStrategy connectionStrategy) {
        this.points = points;
        setDirections(connectionStrategy);
    }

    private void setDirections(ConnectionStrategy connectionStrategy) {
        Map<Integer, Point> lineIndexWithPoint = this.points.stream()
                .collect(Collectors.toMap(Point::value, point -> point));

        Point now = lineIndexWithPoint.get(0);
        now.firstOf(connectionStrategy);
        Point before = now;
        for (int i = 1; i < points.size() - 1; i++) {
            now = lineIndexWithPoint.get(i);
            now.of(before, connectionStrategy);
            before = now;
        }
        lineIndexWithPoint.get(points.size() - 1).lastOf(before);
    }

    public Points getNext(ConnectionStrategy connectionStrategy) {
        List<Point> pointsAfterConnection = new ArrayList<>();
        for (Point before : points) {
            Point after = before.move();
            pointsAfterConnection.add(after);
        }
        return new Points(pointsAfterConnection, connectionStrategy);
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
