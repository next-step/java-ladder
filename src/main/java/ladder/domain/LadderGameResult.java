package ladder.domain;

import java.util.List;

public class LadderGameResult {
    private final Players players;
    private final List<String> results;

    public LadderGameResult(Players players, List<String> results) {
        this.players = players;
        this.results = results;
    }

    public Players players() {
        return players;
    }

    public String getResultFor(Player player) {
        return results.get(player.getPosition());
    }
}
