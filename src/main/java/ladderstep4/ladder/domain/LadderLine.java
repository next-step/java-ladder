package ladderstep4.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderLine {
    public static final int ONE = 1;

    private final List<Point> points;

    public LadderLine(int playerCount) {
        this(new PlayerCount(playerCount));
    }

    public LadderLine(PlayerCount count) {
        this(init(count));
    }

    public LadderLine(List<Point> points) {
        this.points = points;
    }

    private static List<Point> init(PlayerCount count) {
        List<Point> points = new ArrayList<>();

        Point point = Point.first();
        points.add(point);

        for (int i = ONE; i < count.value() - ONE; i++) {
            point = point.next();
            points.add(point);
        }

        points.add(point.last());
        return points;
    }

    public Position move(int count) {
        return move(new Position(count));
    }

    public Position move(Position count) {
        return points.get(count.value()).move();
    }

    public int size() {
        return points.size();
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
