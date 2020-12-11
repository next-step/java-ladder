package domain;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {
    private final Points points;

    private LadderLine(final List<Point> points) {
        this.points = new Points(points);
    }

    public static LadderLine init(final int numberOfPeople) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points);
        point = initBody(numberOfPeople, points, point);
        initLast(points, point);
        return new LadderLine(points);
    }

    public int move(final int index) {
        return points.move(index);
    }

    private static Point initFirst(final List<Point> points) {
        Point point = Point.first(RandomDirectionGenerator.generate());
        points.add(point);
        return point;
    }

    private static Point initBody(final int sizeOfPerson, final List<Point> points, final Point point) {
        Point body = point;
        for (int i = 1; i < sizeOfPerson - 1; i++) {
            body = body.next();
            points.add(body);
        }
        return body;
    }

    private static void initLast(final List<Point> points, final Point point) {
        Point last = point.last();
        points.add(last);
    }

    public Points getPoints() {
        return points;
    }
}
