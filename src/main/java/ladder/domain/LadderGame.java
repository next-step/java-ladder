package ladder.domain;

import ladder.Height;

public class LadderGame {
    private final Players players;
    private final Height height;

    public LadderGame(Players players, Height height) {
        this.players = players;
        this.height = height;
    }

    public Ladder createLadder() {
        return new Ladder(height.value(), players.count() - 1);
    }

    public Players players() {
        return players;
    }
}
