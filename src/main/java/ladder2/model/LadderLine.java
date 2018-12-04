package ladder2.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static ladder2.LadderPointGenerator.generatePoint;

public class LadderLine {
    private final List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public static LadderLine from(int sizeOfParticipants) {
        List<Point> points = new ArrayList<>();
        initLast(points, initBody(sizeOfParticipants, points, initFirst(points)));
        return new LadderLine(points);
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public int pointSize() {
        return points.size();
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    private static Point initFirst(List<Point> points) {
        Point point = Point.first(generatePoint());
        points.add(point);
        return point;
    }

    private static void initLast(List<Point> points, Point bodyLastPoint) {
        points.add(bodyLastPoint.last());
    }

    private static Point initBody(int sizeOfParticipants, List<Point> points, Point firstPoint) {
        Point point = firstPoint;
        for (int i = 1; i < sizeOfParticipants - 1; i++) {
            point = point.next();
            points.add(point);
        }
        return point;
    }

}
