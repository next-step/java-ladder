package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Point> points;

    public Line(int countOfPlayers, PointGenerationStrategy strategy) {
        this.points = createLine(countOfPlayers, strategy);
    }

    public int move(int position) {
        return points.get(position).move();
    }

    private List<Point> createLine(int countOfPlayers, PointGenerationStrategy strategy) {
        List<Point> points = new ArrayList<>();

        Point point = Point.first(strategy);
        points.add(point);

        for (int i = 1; i < countOfPlayers - 1; i++) {
            point = point.next(strategy);
            points.add(point);
        }

        points.add(point.last());

        return points;
    }

    public List<Point> getPoints() {
        return points;
    }
}
