package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderGameResult {
    private final List<Player> players;

    public LadderGameResult(Players players, List<String> results) {
        this.players = createPlayerResults(players, results);
    }

    private List<Player> createPlayerResults(Players players, List<String> results) {
        List<Player> playerResults = new ArrayList<>();
        for (int i = 0; i < players.count(); i++) {
            Player player = players.getPlayerAtIndex(i);
            playerResults.add(player.checkResult(results));
        }
        return playerResults;
    }

    public String getResultFor(String name) {
        return players.stream()
                .filter(player -> player.name().equals(name))
                .findFirst()
                .map(Player::result)
                .orElseThrow(() -> new IllegalArgumentException("Player not found in the game results"));
    }

    public Map<String, String> getResultForAll() {
        return players.stream()
                .collect(Collectors.toMap(Player::name, Player::result));
    }
}
