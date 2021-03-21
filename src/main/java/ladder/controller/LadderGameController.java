package ladder.controller;

import ladder.dto.LadderBoardDto;
import ladder.domain.LadderGame;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGameController {
    public static void run() {
        LadderGame ladderGame = new LadderGame(InputView.ladderGameRequest());
        LadderBoardDto ladderBoardDto = ladderGame.ladderBoard();
        ResultView.printLadderBoard(ladderBoardDto);
    }
}
