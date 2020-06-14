package ladder;

public class LadderGameController {

    private final LadderGame ladderGame;

    public LadderGameController(LadderGame ladderGame) {
        this.ladderGame = ladderGame;
    }

    public void startGame() {
        Players players = InputView.askPlayers();
        Prizes prizes = InputView.askPrizes();
        LadderHeight ladderHeight = InputView.askLadderHeight();

        LadderLines ladderLines = ladderGame.start(players, ladderHeight);
        OutputView.printLadder(players, ladderLines);
    }
}
