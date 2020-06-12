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
        points.add(Point.of(false));

        IntStream.range(1, countOfPlayers)
                .forEach((i) -> points.add(decidePoint(points.get(i - 1), strategy)));

        return points;
    }

    private Point decidePoint(Point point, PointGenerationStrategy strategy) {
        if (point.isPoint()) {
            return Point.of(false);
        }

        return Point.ofStrategy(strategy);
    }

    public List<Point> getPoints() {
        return points;
    }
}
