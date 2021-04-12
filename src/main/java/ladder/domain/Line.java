package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Line {
    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line of(Players players) {
        List<Point> points = new ArrayList<>();
        Optional.ofNullable(players)
                .map(Players::allPlayers)
                .orElseThrow(IllegalArgumentException::new)
                .stream()
                .map(player -> new Point(players.playerPosition(player)))
                .forEach(points::add);
        return new Line(points);
    }

    public LineResult makeLine() {
        LineResult lineResult = new LineResult();
        Point comparePoint = new Point(Position.DEFAULT);
        for (Point point : points) {
            Direction direction = LadderGenerator.generate(point, comparePoint);
            point.setDirection(direction);
            comparePoint = point;

            lineResult.add(point.toPointResult());
        }
        return lineResult;
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}
