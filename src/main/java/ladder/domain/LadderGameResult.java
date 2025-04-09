package ladder.domain;

import java.util.List;

public class LadderGameResult {
    private final Players players;
    private final List<String> results;

    public LadderGameResult(Players players, List<String> results) {
        this.players = players;
        this.results = results;
    }

    public String getResultFor(Player targetPlayer) {
        String name = targetPlayer.name();
        for (int i = 0; i < players.count(); i++) {
            Player selectedPlayer = players.getPlayerAtIndex(i);
            if (selectedPlayer.name().equals(name)) {
                return results.get(selectedPlayer.getPosition().value());
            }
        }
        throw new IllegalArgumentException("Player not found in the game results");
    }

}
