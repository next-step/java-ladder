package step4.refactoring;

import step4.strategy.LineStrategy;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {

    private final List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public static LadderLine init(int sizeOfPerson, LineStrategy lineStrategy) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points, lineStrategy);
        point = initBody(sizeOfPerson, points, point, lineStrategy);
        initLast(points, point);
        return new LadderLine(points);
    }

    private static Point initBody(int sizeOfPerson, List<Point> points, Point point, LineStrategy lineStrategy) {
        for (int i = 1; i < sizeOfPerson - 1; i++) {
            point = point.next(lineStrategy);
            points.add(point);
        }
        return point;
    }

    private static void initLast(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }

    private static Point initFirst(List<Point> points, LineStrategy lineStrategy) {
        Point point = Point.first(lineStrategy.hasLine());
        points.add(point);
        return point;
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "LadderLine{" +
                "points=" + points +
                '}';
    }

}
