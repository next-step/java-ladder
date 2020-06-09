package ladder;

public class LadderGameController {

    private final LadderGame ladderGame;

    public LadderGameController(LadderGame ladderGame) {
        this.ladderGame = ladderGame;
    }

    public void startGame() {
        Ladder ladder = ladderGame.start(InputView.askPlayerNames(), InputView.askLadderHeight());
        OutputView.printLadder(ladder);
    }
}
