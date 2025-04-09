package ladder.domain;

import ladder.Height;

import java.util.List;

public class LadderGame {
    private final Players players;
    private final List<String> results;

    public LadderGame(Players players, List<String> results, Height height) {
        this.players = players;
        this.results = results;
    }

    public Players players() {
        return players;
    }

    public LadderGameResult play(Ladder ladder) {
        List<Integer> result = players.traverse(ladder);
        return new LadderGameResult(players, result);
    }
}
