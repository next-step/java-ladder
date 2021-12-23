package ladder.domain;

import ladder.strategy.GeneratorStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LadderLine {
    private final List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public int move(int position) {
        return points.get(position).move();
    }

    public static LadderLine init(int sizeOfPerson, GeneratorStrategy movingStrategy) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points, movingStrategy);
        point = initBody(sizeOfPerson, points, point, movingStrategy);
        initLast(points, point);
        return new LadderLine(points);
    }

    private static Point initBody(int sizeOfPerson, List<Point> points, Point point, GeneratorStrategy movingStrategy) {
        for (int i = 1; i < sizeOfPerson - 1; i++) {
            point = point.next(movingStrategy);
            points.add(point);
        }
        return point;
    }

    private static void initLast(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }

    private static Point initFirst(List<Point> points, GeneratorStrategy movingStrategy) {
        Point point = Point.first(movingStrategy);
        points.add(point);
        return point;
    }

    @Override
    public String toString() {
        return "LadderLine{" +
                "points=" + points +
                '}';
    }
}