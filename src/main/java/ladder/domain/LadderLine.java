package ladder.domain;

import ladder.strategy.LineCreateStrategy;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {
    private final List<Point> points;

    public LadderLine(int countOfMember, LineCreateStrategy lineCreateStrategy) {
        this(createLine(countOfMember, lineCreateStrategy));
    }

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public int move(int position) {
        return points.get(position).move();
    }

    private static List<Point> createLine(int countOfMember, LineCreateStrategy lineCreateStrategy) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points, lineCreateStrategy);
        point = initBody(countOfMember, points, point, lineCreateStrategy);
        initLast(points, point);
        return points;
    }

    private static Point initBody(int countOfMember, List<Point> points, Point point, LineCreateStrategy lineCreateStrategy) {
        for (int i = 1; i < countOfMember - 1; i++) {
            point = point.next(lineCreateStrategy);
            points.add(point);
        }
        return point;
    }

    private static void initLast(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }

    private static Point initFirst(List<Point> points, LineCreateStrategy lineCreateStrategy) {
        Point point = Point.first(lineCreateStrategy.create());
        points.add(point);
        return point;
    }

    public List<Point> points() {
        return List.copyOf(points);
    }
}
