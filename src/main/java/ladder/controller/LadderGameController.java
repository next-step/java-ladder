package ladder.controller;

import ladder.domain.LadderGame;
import ladder.domain.LadderGameResult;
import ladder.domain.RandomLineBuildStrategy;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGameController {

    public static String[] getPlayerNames() {
        return InputView.inputPlayerNames();
    }

    public static int getLadderMaxHeight() {
        return InputView.inputLadderHeight();
    }

    public static LadderGameResult execute(String[] playerNames, int ladderMaxHeight) {
        LadderGame ladderGame = new LadderGame(new RandomLineBuildStrategy());
        return ladderGame.start(playerNames, ladderMaxHeight);
    }

    public static void showResult(LadderGameResult ladderGameResult) {
        ResultView.showResult(ladderGameResult);
    }
}
