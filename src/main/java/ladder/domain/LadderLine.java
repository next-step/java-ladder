package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderLine {
    private final List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public static LadderLine init(int sizeOfPerson) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points);
        point = initBody(sizeOfPerson, points, point);
        initLast(points, point);
        return new LadderLine(points);
    }

    private static void initLast(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }

    private static Point initBody(int sizeOfPerson, List<Point> points, Point point) {
        for (int i = 1; i < sizeOfPerson - 1; i++) {
            point = point.next();
            points.add(point);
        }
        return point;
    }

    private static Point initFirst(List<Point> points) {
        Point point = Point.first(new Random().nextBoolean());
        points.add(point);
        return point;
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public void draw() {
        for (Point point : points) {
            point.draw();
        }
    }
}
