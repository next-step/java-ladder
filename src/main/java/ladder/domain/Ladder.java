package ladder.domain;

import ladder.domain.bridge.Bridges;
import ladder.domain.bridge.direction.Direction;
import ladder.domain.common.Point;
import ladder.domain.player.Players;

public class Ladder {
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
}
