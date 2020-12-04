package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static domain.Direction.*;

public class Points {
    private List<Point> points;

    private Points(final List<Point> points) {
        this.points = points;
    }

    public static Points of(final Length width) {
        List<Point> points = new ArrayList<>();
        int numberOfPoints = width.value();

        for(int i = 0; i < numberOfPoints; i++) {
            Point point = fetchPointByPosition(Position.of(i), numberOfPoints, points);
            points.add(point);
        }

        return new Points(points);
    }

    private static Point fetchPointByPosition(final Position position, final int numberOfPoints, final List<Point> points) {
        if( !position.equals(Position.FIRST) && isFormerPointConnected(points.get(position.value() - 1))) {
            return Point.of(position, LEFT);
        }

        if(position.value() == numberOfPoints - 1) {
            return Point.of(position, DOWN);
        }

        return Point.of(position, RandomDirectionGenerator.generate());
    }

    private static boolean isFormerPointConnected(final Point point) {
        return point.isHeadingRight();
    }

    public Stream<Point> stream() {
        return points.stream();
    }

    public Position movePointAt(final Position position) {
        return points.get(position.value()).next();
    }
}
