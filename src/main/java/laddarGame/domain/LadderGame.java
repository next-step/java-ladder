package laddarGame.domain;

public class LadderGame {

    private Ladder ladder;

    public LadderGame(String playerNames, int ladderHeight) {
        this.ladder = new Ladder(playerNames, ladderHeight);
    }
}
