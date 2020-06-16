package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final List<Point> points;

    public Line(int countOfPlayers, PointGenerationStrategy strategy) {
        this.points = createLine(countOfPlayers, strategy);
    }

    private List<Point> createLine(int countOfPlayers, PointGenerationStrategy strategy) {
        List<Point> points = new ArrayList<>();

        Point point = Point.first(strategy);
        points.add(point);

        IntStream.range(1, countOfPlayers - 1)
                .forEach((i) -> points.add(point.next(strategy)));

        points.add(point.last());

        return points;
    }

    public List<Point> getPoints() {
        return points;
    }
}
