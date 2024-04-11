package ladder.controller;

import ladder.model.GameResult;
import ladder.model.GameResultList;
import ladder.model.Ladder;
import ladder.model.NameList;
import ladder.model.utils.ConnectLine;
import ladder.model.utils.ConnectLineRandom;
import ladder.model.utils.StringToIntConverter;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {
    public static void run() {
        String nameString = InputView.nameOfPlayer();
        NameList nameList = new NameList(nameString);

        String resultString = InputView.resultOfGame();
        GameResultList gameResultList = new GameResultList(resultString, nameList.numOfName());

        int heightOfLadder = StringToIntConverter.toInt(InputView.heightOfLadder());
        ConnectLine connectLine = new ConnectLineRandom();
        Ladder ladder = new Ladder(heightOfLadder, nameList.numOfName(), connectLine);

        GameResult gameResult = new GameResult(nameList, gameResultList);
        OutputView.printLadderGameResult(nameList, ladder, gameResultList);

        gameResult.ladderGame(ladder);

        String resultPlayer = InputView.printWantToKnowResult();
        OutputView.printResultOfGame(gameResult, resultPlayer);
    }
}
