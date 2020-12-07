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

    public static LadderBuildResult execute(String[] playerNames, String ladderMaxHeightValue) {
        Players players = new Players(playerNames);
        validateLadderMaxHeight(ladderMaxHeightValue);

        //Awards awards = new Awards(awardNames);

        LadderGame ladderGame = new LadderGame(new RandomLineBuildStrategy());
        return new LadderBuildResult(ladderGame.start(players.getPlayers().size(), Integer.parseInt(ladderMaxHeightValue)), players);
    }

    private static void validateLadderMaxHeight(String ladderMaxHeightValue) {
        if(!ladderMaxHeightValue.matches(MAX_HEIGHT_PATTERN)){
            throw new IllegalArgumentException(LadderGameErrorMessage.ILLEGAL_MAX_HEIGHT.getErrorMessage());
        }
    }

    public static void showBuildResult(LadderBuildResult ladderBuildResult, Awards awards) {
        ResultView.showBuildResult(ladderBuildResult, awards);
    }

    public static String[] getLadderGameAwards(int ladderCount) {
        return InputView.inputLadderGameAwards(ladderCount);
    }

    public static Awards makeAwards(String[] awardNames) {
        return new Awards(awardNames);
    }
}
