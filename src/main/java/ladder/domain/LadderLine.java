package ladder.domain;

import java.util.ArrayList;
import java.util.List;

import ladder.exception.PersonCountException;
import ladder.strategy.MovableStrategy;
import ladder.strategy.NoMovableStrategy;
import ladder.strategy.RandomlyMovableStrategy;

public class LadderLine {
    private final List<Point> points;

    private LadderLine(List<Point> points) {
        this.points = points;
    }

    public static LadderLine from(List<Point> points) {
        return new LadderLine(points);
    }

    public static LadderLine init(int sizeOfPerson, MovableStrategy movableStrategy) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points, movableStrategy);
        point = initBody(sizeOfPerson, points, point, movableStrategy);
        initLast(points, point);
        return new LadderLine(points);
    }

    private static Point initBody(int sizeOfPerson, List<Point> points, Point point, MovableStrategy movableStrategy) {
        for (int i = 1; i < sizeOfPerson - 1; i++) {
            point = point.next(movableStrategy);
            points.add(point);
        }
        return point;
    }

    private static void initLast(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }

    private static Point initFirst(List<Point> points, MovableStrategy movableStrategy) {
        Point point = Point.first(generatePoint(movableStrategy));
        points.add(point);
        return point;
    }

    private static boolean generatePoint(MovableStrategy movableStrategy) {
        return movableStrategy.isMovable();
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
