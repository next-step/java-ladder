package ladder.domain;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.FALSE;

public class PointGenerator {
    private final int playerCounts;
    private List<Point> points;

    public PointGenerator(final int countOfPlayers) {
        this.playerCounts = countOfPlayers;
        this.points = new ArrayList<>();
    }

    public List<Point> generate() {
        Point first = Point.first(FALSE);
        points.add(first);

        for (int i = 1; i < playerCounts - 1; i++) {
            points.add(first.next(generateRandom()));
        }
        points.add(first.last());
        return new ArrayList<>(points);
    }

    private Boolean generateRandom() {
        return Math.round(Math.random()) < 0.5;
    }
}
