package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {
    private final List<Point> points;

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    public int move(int position) {
        return points.get(position).move().toInt();
    }

    public static LadderLine init(int sizeOfPerson, LadderPointGenerateStrategy strategy) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points, strategy.generatePoint());
        point = initBody(sizeOfPerson, points, point, strategy);
        initLast(points, point);
        return new LadderLine(points);
    }

    // todo refactor: too many parameter
    private static Point initBody(int sizeOfPerson, List<Point> points, Point point, LadderPointGenerateStrategy strategy) {
        for (int i = 1; i < sizeOfPerson - 1; i++) {
            point = point.next(strategy.generatePoint());
            points.add(point);
        }
        return point;
    }

    private static void initLast(List<Point> points, Point point) {
        point = point.last();
        points.add(point);
    }

    private static Point initFirst(List<Point> points, boolean first) {
        Point point = Point.first(first);
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