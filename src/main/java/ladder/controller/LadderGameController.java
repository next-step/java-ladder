package ladder.controller;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGameController {

    private static final String MAX_HEIGHT_PATTERN = "(\\d+)";

    public static String[] getPlayerNames() {
        return InputView.inputPlayerNames();
    }

    public static String getLadderMaxHeight() {
        return InputView.inputLadderHeight();
    }

    public static LadderGameResult execute(String[] playerNames, String ladderMaxHeightValue) {
        Players players = new Players(playerNames);
        validateLadderMaxHeight(ladderMaxHeightValue);

        LadderGame ladderGame = new LadderGame(new RandomLineBuildStrategy());
        return new LadderGameResult(ladderGame.start(players.getPlayers().size(), Integer.parseInt(ladderMaxHeightValue)), players);
    }

    private static void validateLadderMaxHeight(String ladderMaxHeightValue) {
        if(!ladderMaxHeightValue.matches(MAX_HEIGHT_PATTERN)){
            throw new IllegalArgumentException(LadderGameErrorMessage.ILLEGAL_MAX_HEIGHT.getErrorMessage());
        }
    }

    public static void showResult(LadderGameResult ladderGameResult) {
        ResultView.showResult(ladderGameResult);
    }
}
