package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGameResult {
    private final Players players;

    public LadderGameResult(Players players, List<String> results) {
        this.players = createPlayerResults(players, results);
    }

    private Players createPlayerResults(Players players, List<String> results) {
        List<Player> playerResults = new ArrayList<>();
        for (int i = 0; i < players.count(); i++) {
            Player player = players.getPlayerAtIndex(i);
            playerResults.add(player.checkResult(results));
        }
        return new Players(playerResults);
    }

    public Player findPlayer(String name) {
        return players.findPlayer(name);
    }

    public List<Player> getAllPlayers() {
        return IntStream.range(0, players.count())
                .mapToObj(players::getPlayerAtIndex)
                .collect(Collectors.toList());
    }
}
