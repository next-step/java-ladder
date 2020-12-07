package ladder.controller;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

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

    public static Map<Player, Award> climb(LadderBuildResult ladderBuildResult, Awards awards) {
        Map<Integer, Integer> climbResult = new HashMap<>();

        IntStream.range(0, ladderBuildResult.getPlayers().getPlayers().size())
                .forEach(i -> climbResult.put(i, ladderBuildResult.getLadders().climb(i)));

        return parseClimbResult(climbResult, ladderBuildResult.getPlayers(), awards);

    }

    private static Map<Player, Award> parseClimbResult(Map<Integer, Integer> climbResult, Players players, Awards awards) {
        Map<Player, Award> playerAwardMap = new HashMap<>();

        climbResult.entrySet().stream()
                .forEach(indexEntry -> playerAwardMap.put((players.searchPlayerName(indexEntry.getKey()))
                        , awards.searchAwardName(indexEntry.getValue())));

        return playerAwardMap;
    }


    public static String getPlayerResult() {
        return InputView.getPlayerResult();
    }

    public static void showPlayerResult(Map<Player, Award> climbResult, String player) {
        ResultView.printPlayerResult(climbResult, player);
    }
}
