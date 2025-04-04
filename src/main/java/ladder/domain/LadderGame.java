package ladder.domain;

public class LadderGame {
    private final Players players;
    private final int height;

    public LadderGame(Players players, int height) {
        this.players = players;
        this.height = height;
    }

    public Ladder createLadder() {
        return new Ladder(height, players.count() - 1);
    }

    public Players players() {
        return players;
    }
}
