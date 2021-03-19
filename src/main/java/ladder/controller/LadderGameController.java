package ladder.controller;

import ladder.domain.LadderBoard;
import ladder.domain.LadderGame;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGameController {
    public static void run() {
        LadderGame ladderGame = new LadderGame(InputView.ladderGameRequest());
        LadderBoard ladderBoard = ladderGame.ladderBoard();
        ResultView.printLadderBoard(ladderBoard);
    }
}
