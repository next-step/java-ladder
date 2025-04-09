package ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGameResult {
    private final Map<String, String> playerResults;

    public LadderGameResult(Players players, List<String> results) {
        this.playerResults = createPlayerResults(players, results);
    }

    private Map<String, String> createPlayerResults(Players players, List<String> results) {
        Map<String, String> playerResults = new HashMap<>();
        for (int i = 0; i < players.count(); i++) {
            Player player = players.getPlayerAtIndex(i);
            String result = results.get(player.getPosition().value());
            playerResults.put(player.name(), result);
        }
        return playerResults;
    }

    public String getResultFor(Player targetPlayer) {
        String name = targetPlayer.name();
        if (playerResults.containsKey(name)) {
            return playerResults.get(name);
        }
        throw new IllegalArgumentException("Player not found in the game results");
    }

}
