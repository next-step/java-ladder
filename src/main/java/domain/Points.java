package domain;

import java.util.ArrayList;
import java.util.List;

import static domain.Direction.*;

public class Points {
    private List<Point> points;

    protected Points(final List<Point> points) {
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
        if(isHeadingLeft(position, points)) {
            return Point.of(position, LEFT);
        }

        if(isLastPoint(position, numberOfPoints)) {
            return Point.of(position, DOWN);
        }

        return Point.of(position, RandomDirectionGenerator.generate());
    }

    private static boolean isHeadingLeft(Position position, List<Point> points) {
        return position.value() != 0 && points.get(position.value() - 1).isHeadingRight();
    }

    private static boolean isLastPoint(Position position, int numberOfPoints) {
        return position.value() == numberOfPoints - 1;
    }

    public Position movePointAt(final Position position) {
        return points.get(position.value()).next();
    }

    public List<Point> getPoints() {
        return points;
    }
}
