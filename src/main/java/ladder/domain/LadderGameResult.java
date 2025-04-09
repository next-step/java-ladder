package ladder.domain;

import java.util.List;

public class LadderGameResult {
    private final Players players;
    private final List<Integer> results;

    public LadderGameResult(Players players, List<Integer> results) {
        this.players = players;
        this.results = results;
    }

    public Players players() {
        return players;
    }

    public List<Integer> results() {
        return results;
    }

    public Integer getResultFor(Player player) {
        return player.getPosition();
    }
}
