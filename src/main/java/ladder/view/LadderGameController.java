package ladder.view;

import ladder.application.LadderGame;
import ladder.domain.*;

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
        PositionLogs positionLogs = ladderGame.play(players, ladderLines);

        OutputView.printResult(players, ladderLines, prizes, positionLogs);
    }
}
