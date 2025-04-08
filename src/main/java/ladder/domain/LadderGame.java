package ladder.domain;

import ladder.Height;
import ladder.domain.ladderlinegenerator.RandomLadderLineGenerator;

public class LadderGame {
    private final Players players;
    private final Height height;

    public LadderGame(Players players, Height height) {
        this.players = players;
        this.height = height;
    }

    public Ladder createLadder() {
        return new Ladder(height.value(), players.count() - 1, new RandomLadderLineGenerator());
    }

    public Players players() {
        return players;
    }
}
