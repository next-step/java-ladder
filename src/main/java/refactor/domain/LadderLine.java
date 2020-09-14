package refactor.domain;

import refactor.domain.pointGenerate.PointStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderLine {
    private final List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public static LadderLine init(int sizeOfPerson, PointStrategy pointStrategy) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points, pointStrategy);
        point = initBody(sizeOfPerson, points, point, pointStrategy);
        initLast(points, point);
        return new LadderLine(points);
    }

    private static Point initBody(int sizeOfPerson, List<Point> points, Point point, PointStrategy pointStrategy) {
        for (int i = 1; i < sizeOfPerson - 1; i++) {
            point = point.next(pointStrategy);
            points.add(point);
        }
        return point;
    }

    private static void initLast(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }

    private static Point initFirst(List<Point> points, PointStrategy pointStrategy) {
        Point point = Point.first(pointStrategy.generatePoint());
        points.add(point);
        return point;
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}