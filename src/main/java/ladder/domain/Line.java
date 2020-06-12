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
                .forEach((i) -> {
                    if (points.get(i - 1).isPoint()) {
                        points.add(Point.of(false));
                    } else {
                        points.add(Point.ofStrategy(strategy));
                    }
                });

        return points;
    }

    public List<Point> getPoints() {
        return points;
    }
}
