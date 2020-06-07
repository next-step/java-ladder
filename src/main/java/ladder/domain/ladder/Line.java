package ladder.domain.ladder;

import ladder.domain.player.LadderPlayers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static ladder.domain.ladder.RandomGenerator.isMovable;

public class Line {

    private static final int PERSON_START_END_COUNT = 2;

    private List<Point> points = new ArrayList<>();

    private Line (LadderPlayers ladderPlayers) {
        lineMaker(ladderPlayers);
    }

    public static Line createLine(LadderPlayers ladderPlayers) {
        return new Line(ladderPlayers);
    }

    private List<Point> lineMaker(LadderPlayers ladderPlayers) {
        int countOfPerson = ladderPlayers.getPlayerCount();

        Point point = Point.first(isMovable());
        points.add(point);

        int i = 0;

        while (countOfPerson - PERSON_START_END_COUNT > i) {
            point = point.next(isMovable());
            points.add(point);
            i += 1;
        }

        points.add(point.last());
        return Collections.unmodifiableList(points);
    }

    public List<Point> getPoints() {
        return points;
    }
}
