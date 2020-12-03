package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static domain.Direction.*;
import static domain.RandomDirectionGenerator.generate;

public class Points {
    private final List<Point> points;
    private Points(final List<Point> points) {
        this.points = points;
    }

    public static Points of(final Length width) {
        List<Point> points = new ArrayList<>();
        int numberOfPoints = width.getValue();


        for(int i = 0; i < numberOfPoints; i++) {
            Point point = fetchPointByPosition(i, numberOfPoints, points);
            points.add(point);
        }

        return new Points(points);
    }

    private static Point fetchPointByPosition(int position, int numberOfPoints, List<Point> points) {
        if(position == 0) {
            return Point.of(0, generate());
        }

        if(position == numberOfPoints - 1) {
            return Point.of(position, IsFormerPointConnected(points.get(position-1)) ? LEFT : DOWN);
        }

        return Point.of(position, IsFormerPointConnected(points.get(position-1)) ? LEFT : generate());
    }

    private static boolean IsFormerPointConnected(Point point) {
        return point.getDirection() == RIGHT;
    }

    public Stream<Point> stream() {
        return points.stream();
    }

}
