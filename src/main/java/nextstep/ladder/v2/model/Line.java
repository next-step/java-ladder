package nextstep.ladder.v2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private List<Point> points;

    public Line() {
        this.points = new ArrayList<>();
    }

    public Line(int countOfPlayers, PointGenerator pointGenerator) {
        this.points = createPoints(countOfPlayers, pointGenerator);
    }

    private static List<Point> createPoints(int countOfPlayers, PointGenerator pointGenerator) {
        List<Point> points = new ArrayList<>();
        points.add(Point.first(pointGenerator));
        if (countOfPlayers > 1) {
            IntStream.range(0, countOfPlayers - 2)
                    .forEach(idx -> points.add(points.get(idx).next(pointGenerator)));
            points.add(points.get(countOfPlayers - 2).last());
        }
        return points;
    }

    public List<Point> getPoints() {
        return points;
    }

    public int move(int startPos) {
        return this.points.get(startPos).getNextPosition(startPos);
    }
}
