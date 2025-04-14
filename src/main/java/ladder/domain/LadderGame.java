package ladder.domain;

import java.util.List;

public class LadderGame {
    private final Players players;
    private final List<String> results;

    public LadderGame(Players players, List<String> results) {
        this.players = players;
        this.results = results;
    }

    public Players players() {
        return players;
    }

    public LadderGameResult play(Ladder ladder) {
        Players traversed = players.traverse(ladder);
        return new LadderGameResult(traversed, results);
    }

    public List<String> getResults() {
        return results;
    }
}
