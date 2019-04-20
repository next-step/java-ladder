package domain;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {
    private List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public static LadderLine init(int countOfPerson, Level level) {
        List<Point> points = new ArrayList<>();
        Point point = initFirstPoint(points, level);
        point = initNextPoint(points, countOfPerson, point, level);
        initLastPoint(points, point);

        return new LadderLine(points);
    }

    private static Point initFirstPoint(List<Point> points, Level level) {
        Point point = Point.first(level);
        points.add(point);
        return point;
    }

    private static Point initNextPoint(List<Point> points, int countOfPerson, Point point, Level level) {
        for (int i = 1; i < countOfPerson - 1; i++) {
            point = point.next(level);
            points.add(point);
        }

        return point;
    }

    private static void initLastPoint(List<Point> points, Point point) {
        points.add(point.last());
    }

    public int movePoint(int startPoint) {
        return startPoint + this.points.get(startPoint).movePoint();
    }

    public String printLine() {
        String result = "";
        for (Point point : this.points) {
            result += point.lineType();
        }

        return result;
    }
}
