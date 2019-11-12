package ladder.domain;

import ladder.domain.bridge.Bridges;
import ladder.domain.bridge.direction.Direction;
import ladder.domain.common.Point;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.result.Destination;
import ladder.domain.result.Destinations;
import ladder.domain.result.Result;
import ladder.domain.result.Results;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final int SYNC = 1;
    private final Players players;
    private final Bridges bridges;

    public Ladder(Players players, Bridges bridges) {
        this.players = players;
        this.bridges = bridges;
    }

    public Players getPlayers() {
        return players;
    }

    public int getMaxLength() {
        return players.getMaxLength();
    }

    public int getRange() {
        return players.getRange();
    }

    public int getHeight() {
        return bridges.getHeight();
    }

    public Direction getDirection(int x, int y) {
        Point targetPoint = new Point(x, y);
        return this.bridges.findDirection(targetPoint);
    }

    public Results makeResults(Destinations destinations) {
        List<Result> results = new ArrayList<>();
        for (Player player : players.getPlayers()) {
            Point point = player.getNextPoint();

            point = findDestinationPoint(point);

            Destination destination = destinations.findDestination(point);
            results.add(new Result(player, destination));
        }
        return new Results(results);
    }

    private Point findDestinationPoint(Point point) {
        while (reachDestination(point)) {
            point = findNextPoint(point);
        }
        return point;
    }

    private boolean reachDestination(Point point) {
        return point.getY() != bridges.getHeight() + SYNC;
    }

    private Point findNextPoint(Point point) {
        return bridges.findNextPoint(point);
    }
}
