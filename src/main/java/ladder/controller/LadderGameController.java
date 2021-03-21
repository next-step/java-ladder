package ladder.controller;

import ladder.domain.LadderGame;
import ladder.dto.LadderGameResult;
import ladder.dto.LadderResultDto;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderGameController {
    public static void run() {
        LadderGame ladderGame = new LadderGame(InputView.ladderGameRequest());
        LadderResultDto ladderResultDto = ladderGame.ladderBoard();
        ResultView.printLadderBoard(ladderResultDto);
        List<LadderGameResult> gameResultList = ladderGame.play(InputView.playerName());
        ResultView.printResult(gameResultList);
    }
}
