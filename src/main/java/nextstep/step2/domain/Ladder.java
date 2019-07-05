package nextstep.step2.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return lines;
    }

    private Result getPlayerReward(final Player player, final GameResults gameResults) {
        var position = player.getStartPoint();
        for (Line line : lines) {
            final var point = line.getPoint(position);
            position = point.move();
        }

        return gameResults.findByPosition(position);
    }

    public Map<Player, Result> getPlayerRewards(final Players players, final GameResults gameResults) {
        Map<Player, Result> playerRewards = new HashMap<>();
        for (Player player : players.getPlayers()) {
            playerRewards.put(player, getPlayerReward(player, gameResults));
        }
        return playerRewards;
    }

    @Override
    public String toString() {
        return "Ladder : " + lines;
    }
}
