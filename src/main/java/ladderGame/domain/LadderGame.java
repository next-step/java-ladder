package ladderGame.domain;

public class LadderGame {

    private Players playes;
    private Ladder ladder;

    public LadderGame(Players players, int height) {
        this.playes = players;
        this.ladder = Ladder.of(players.size(), height);
    }

    public Ladder getLadder() {
        return ladder;
    }
}
