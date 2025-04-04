package ladder.domain;

public class LadderGame {
    private final Players players;
    private final int width;

    public LadderGame(Players players, int width) {
        this.players = players;
        this.width = width;
    }

    public Ladder createLadder() {
        return new Ladder(players.count(), width);
    }
}
