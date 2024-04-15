package ladder.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Results {
    private List<Result> results;

    public Results(List<Result> results) {
        this.results = results;
    }

    public List<Result> getResults() {
        return results;
    }

    public Result getResultByIndex(int index) {
        return results.get(index);
    }

    public Map<Player, Result> playerResults(Lines lines, Players players, Player targetPlayer) {
        if (targetPlayer == null) {
            return players.getPlayers().stream()
                    .collect(Collectors.toMap(
                            player -> player,
                            player -> getResultForPlayer(lines, players, player)
                    ));
        }
        return Map.of(targetPlayer, getResultForPlayer(lines, players, targetPlayer));
    }

    private Result getResultForPlayer(Lines lines, Players players, Player player) {
        int playerInitialPosition = players.getIndexOfPlayer(player);
        return getResultByIndex(lines.runPlayerGoLines(playerInitialPosition));
    }
}
