package ladder.domain.ladder;

import ladder.domain.strategy.LineStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LadderLine {

    private final List<Point> points;

    private LadderLine(List<Point> points) {
        this.points = points;
    }

    public static LadderLine of(int countOfPerson, LineStrategy lineStrategy) {
        List<Point> points = new ArrayList<>();
        initFirst(points, lineStrategy);
        initBody(countOfPerson, points, lineStrategy);
        initLast(points);
        return new LadderLine(points);
    }

    private static void initFirst(List<Point> points, LineStrategy lineStrategy) {
        Point point = Point.first(lineStrategy.hasLine());
        points.add(point);
    }

    private static void initBody(int countOfPerson, List<Point> points, LineStrategy lineStrategy) {
        IntStream.range(1, countOfPerson - 1).forEach(i -> points.add(points.get(i - 1).next(lineStrategy)));
    }

    private static void initLast(List<Point> points) {
        points.add(points.get(points.size() - 1));
    }

    public int move(int position) {
        return points.get(position).move();
    }
}
