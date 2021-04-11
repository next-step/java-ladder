package ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Line {
    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public static Line init(Players players) {
        List<Point> points = new ArrayList<>();
        Optional.ofNullable(players)
                .map(Players::allPlayers)
                .orElseThrow(IllegalArgumentException::new)
                .stream()
                .map(player -> new Point(players.playerPosition(player)))
                .forEach(points::add);
        return new Line(points);
    }

    public void makeLine() {
        Point comparePoint = new Point(Position.DEFAULT);
        for (Point point : points) {
            point.setDirection(LadderGenerator.generate(point, comparePoint));
            comparePoint = point;
        }
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}
