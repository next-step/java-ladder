package step4.domain;

import static step4.domain.LadderPointGenerator.*;

import java.util.ArrayList;
import java.util.List;

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
        for (int i = 0; i < sizeOfPerson - 2; i++) {
            point = point.next();
            points.add(point);
        }
        return point;
    }

    private static Point initFirst(List<Point> points) {
        Point point = Point.first(generatePoint());
        points.add(point);
        return point;
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public List<Point> points() {
        return points;
    }

    public List<Point> getPoints() {
        return points;
    }
}
