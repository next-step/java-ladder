package domain;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {
    private List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public static LadderLine init(int countOfPerson) {
        List<Point> points = new ArrayList<>();
        Point point = initFirstPoint(points);
        point = initNextPoint(points, countOfPerson, point);
        initLastPoint(points, point.isRightMovable());

        return new LadderLine(points);
    }

    private static Point initFirstPoint(List<Point> points) {
        Point point = Point.createPoint(false, Point.isNextPoint(false));
        points.add(point);
        return point;
    }

    private static Point initNextPoint(List<Point> points, int countOfPerson, Point point) {
        for (int i = 1; i < countOfPerson - 1; i++) {
            point = Point.createPoint(point.isRightMovable(), Point.isNextPoint(point.isRightMovable()));
            points.add(point);
        }

        return point;
    }

    private static void initLastPoint(List<Point> points, boolean isRightMovable) {
        points.add(Point.createPoint(isRightMovable, false));
    }

    public int movePoint(int startPoint) {
        return startPoint + this.points.get(startPoint).movePoint();
    }

    public String printLine() {
        String result = "";
        for (Point point : this.points) {
            result += point.lineType(point);
        }

        return result;
    }
}
