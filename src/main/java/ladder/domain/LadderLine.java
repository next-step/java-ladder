package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {
    private final List<Point> points;

    public LadderLine(int countOfPlayers, PointGenerationStrategy strategy) {
        this.points = init(countOfPlayers, strategy);
    }

    public int move(int position) {
        return points.get(position).move();
    }

    private List<Point> init(int countOfPlayers, PointGenerationStrategy strategy) {
        List<Point> points = new ArrayList<>();
        Point point = initFirst(points, strategy);
        point = initBody(countOfPlayers, points, point, strategy);
        initLast(points, point);
        return points;
    }

    private Point initFirst(List<Point> points, PointGenerationStrategy strategy) {
        Point point = Point.first(strategy);
        points.add(point);
        return point;
    }

    private static Point initBody(int countOfPlayers, List<Point> points, Point point, PointGenerationStrategy strategy) {
        for (int i = 1; i < countOfPlayers - 1; i++) {
            point = point.next(strategy);
            points.add(point);
        }
        return point;
    }

    private void initLast(List<Point> points, Point point) {
        points.add(point.last());
    }

    public List<Point> getPoints() {
        return points;
    }
}
