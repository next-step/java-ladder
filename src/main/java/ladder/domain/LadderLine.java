package ladder.domain;

import java.util.ArrayList;
import java.util.List;

import ladder.exception.PersonCountException;
import ladder.strategy.RandomlyMovableStrategy;

public class LadderLine {
    private final List<Point> points;

    private LadderLine(List<Point> points) {
        this.points = points;
    }

    public static LadderLine from(List<Point> points) {
        return new LadderLine(points);
    }

    public static LadderLine init(int sizeOfPerson) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points);
        point = initBody(sizeOfPerson, points, point);
        initLast(points, point);
        return new LadderLine(points);
    }

    private static Point initBody(int sizeOfPerson, List<Point> points, Point point) {
        for (int i = 1; i < sizeOfPerson - 1; i++) {
            point = point.next();
            points.add(point);
        }
        return point;
    }

    private static void initLast(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }

    private static Point initFirst(List<Point> points) {
        Point point = Point.first(generatePoint());
        points.add(point);
        return point;
    }

    private static boolean generatePoint() {
        return new RandomlyMovableStrategy().isMovable();
    }

    public boolean existLeftOf(Index index) {
        return points.get(index.val()).move() - index.val() < 0;
    }

    public boolean existRightOf(Index index) {
        return points.get(index.val()).move() - index.val() > 0;
    }

    public int move(int position) {
        return points.get(position).move();
    }

    @Override
    public String toString() {
        return "LadderLine{" +
            "points=" + points +
            '}';
    }

    public List<Point> toList() {
        return points;
    }

}
