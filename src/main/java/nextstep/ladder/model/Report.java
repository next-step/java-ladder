package nextstep.ladder.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Report {

    private final Map<Player, Result> playerResults = new HashMap<>();

    public Report(Players players, Results results) {
        int size = players.getPlayers().size();

        for (int i = 0; i < size; i++) {
            Index index = new Index(i);
            Player player = players.findPlayerByIndex(index);
            Result result = results.findResultByIndex(index);
            playerResults.put(player, result);
        }
    }

    public Result findResultByPlayerName(String name) {
        return playerResults.get(
                playerResults.keySet().stream()
                        .filter(player -> name.equals(player.getName()))
                        .findFirst()
                        .orElseThrow(() -> new IllegalArgumentException(Players.EXCEPTION_NOT_FOUND_PLAYER))
        );
    }

    public Map<Player, Result> getPlayerResults() {
        return Collections.unmodifiableMap(playerResults);
    }
}
