package domain;

import utils.LadderPointGenerator;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {
    private final String VERTICAL_BAR = "|";
    private final List<Point> points;

    private LadderLine(List<Point> points) {
        this.points = points;
    }

    public static LadderLine ofList(List<Point> points) {
        return new LadderLine(points);
    }

    public int move(int position) {
        return (this.points.get(position)).move();
    }

    public static LadderLine init(int sizeOfPerson, Difficult difficult) {
        if (sizeOfPerson < 0) {
            throw new IllegalArgumentException("음수가 올 수 없습니다.");
        }
        List<Point> points = new ArrayList();
        Point point = initFirst(points, difficult);
        point = initBody(sizeOfPerson, points, point, difficult);
        initLast(points, point);
        return new LadderLine(points);
    }

    private static Point initBody(int sizeOfPerson, List<Point> points, Point point, Difficult difficult) {
        for (int i = 1; i < sizeOfPerson - 1; ++i) {
            point = point.next(difficult);
            points.add(point);
        }

        return point;
    }

    private static void initLast(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }

    private static Point initFirst(List<Point> points, Difficult difficult) {
        Point point = Point.first(LadderPointGenerator.generatePoint(difficult));
        points.add(point);
        return point;
    }

    public String toString() {
        return points.stream()
                .map(point -> point.toString())
                .reduce("", (x, y) -> x + VERTICAL_BAR + y);
    }

}
