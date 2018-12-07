package domain;

import util.DirectionGenerator;

import java.util.ArrayList;
import java.util.List;

public class Points {

    private final List<Point> points;

    private Points(final List<Point> points) {
        this.points = points;
    }

    public static Points from(final int sizeOfPlayers, final DirectionGenerator generator) {
        final List<Point> points = new ArrayList<>();
        Point point = initFirst(points, generator);
        point = initBody(sizeOfPlayers, points, point);
        initLast(points, point);
        return new Points(points);
    }

    public int move(final int position) {
        return points.get(position).move();
    }

    private static Point initFirst(final List<Point> points, final DirectionGenerator generator) {
        final Point point = Point.first(generator.apply());
        points.add(point);
        return point;
    }

    private static Point initBody(final int sizeOfPlayers, final List<Point> points, Point point) {
        for (int index = 1; index < sizeOfPlayers - 1; index++) {
            point = point.next();
            points.add(point);
        }
        return point;
    }

    private static void initLast(final List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (Point point : this.points) {
            sb.append(point.toString());
        }
        return sb.toString();
    }

}
