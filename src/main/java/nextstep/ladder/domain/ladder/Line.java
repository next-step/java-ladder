package nextstep.ladder.domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Point> points;

    public static Line from(LineMaterial lineMaterial) {
        List<Point> points = new ArrayList<>();
        Point firstPoint = addFirstPoint(lineMaterial.getDirectionStrategy(), points);
        Point lastMiddlePoint = addMiddlePoints(lineMaterial, points, firstPoint);
        addLastPoint(lastMiddlePoint, points);
        return new Line(points);
    }

    private static Point addFirstPoint(final DirectionStrategy directionStrategy, final List<Point> points) {
        Point point = Point.first(directionStrategy);
        points.add(point);
        return point;
    }

    private static Point addMiddlePoints(final LineMaterial lineMaterial, final List<Point> points, Point point) {
        int sizeOfMiddlePoints = lineMaterial.getSizeOfMiddlePoints();
        DirectionStrategy directionStrategy = lineMaterial.getDirectionStrategy();

        for (int i = 0; i < sizeOfMiddlePoints; i++) {
            point = point.next(directionStrategy);
            points.add(point);
        }
        return point;
    }

    private static void addLastPoint(final Point point, final List<Point> points) {
        points.add(point.last());
    }

    private Line(final List<Point> points) {
        this.points = new ArrayList<>(Collections.unmodifiableList(points));
    }

    //todo 선택: List.get() 과 stream
    public Location move(Location location) {
        return points.stream()
                .filter(point -> point.isEqualLocation(location))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .move();
    }

    int sizeOfPoint() {
        return points.size();
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}
