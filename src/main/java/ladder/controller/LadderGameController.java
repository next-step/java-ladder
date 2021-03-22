package ladder.controller;

import ladder.domain.LadderGame;
import ladder.dto.LadderGameResult;
import ladder.dto.LadderResultDto;
import ladder.dto.LineDto;
import ladder.dto.PointDto;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderGameController {
    public static void run() {
        LadderGame ladderGame = new LadderGame(InputView.ladderGameRequest());
        LadderResultDto ladderResultDto = ladderGame.ladderBoard();
        printLadderResult(ladderResultDto);
        List<LadderGameResult> gameResultList = ladderGame.play(InputView.playerName());
        printResult(gameResultList);
    }

    public static void printLadderResult(LadderResultDto ladderResultDto) {
        ResultView.printPlayerNameList(ladderResultDto.playerNameList());

        printLadderLineList(ladderResultDto.lineList());

        ResultView.printPrizeNameList(ladderResultDto.prizeNameList());
    }

    private static void printLadderLineList(List<LineDto> lineList) {

    }

    private static void printSingeLine(LineDto line){
        for (PointDto point:line.pointList()) {
            if(point.isFilled()) ResultView.printEmptyPoint();
        }
    }
    public static void printResult(List<LadderGameResult> gameResultList) {
        ResultView.printResult(gameResultList);
    }
}
