package ladder.domain;

import ladder.Height;
import ladder.domain.ladderlinegenerator.RandomLadderLineGenerator;

import java.util.List;

public class LadderGame {
    private final Players players;
    private final List<String> results;
    private final Height height;

    public LadderGame(Players players, List<String> results, Height height) {
        this.players = players;
        this.results = results;
        this.height = height;
    }

    public Ladder createLadder() {
        return new Ladder(height.value(), players.count() - 1, new RandomLadderLineGenerator());
    }

    public Players players() {
        return players;
    }
}
