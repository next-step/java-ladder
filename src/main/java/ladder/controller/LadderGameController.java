package ladder.controller;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class LadderGameController {

    private static final int FIRST_INDEX = 0;
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

        return new LadderBuildResult(new LadderGame().start(players.getPlayers().size(), Integer.parseInt(ladderMaxHeightValue)), players);
    }

    private static void validateLadderMaxHeight(String ladderMaxHeightValue) {
        if(!ladderMaxHeightValue.matches(MAX_HEIGHT_PATTERN)){
            throw new IllegalArgumentException("최대 사다리 높이를 숫자로 입력하세요.");
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

    public static ClimbResults climb(LadderBuildResult ladderBuildResult, Awards awards) {

        Paths paths = new Paths(IntStream.range(FIRST_INDEX, ladderBuildResult.getPlayers().getPlayers().size())
                .mapToObj(i -> Path.of(i, ladderBuildResult.getLadders().climb(i))).collect(Collectors.toList()));

        return parseClimbResult(paths, ladderBuildResult.getPlayers(), awards);

    }

    private static ClimbResults parseClimbResult(Paths paths, Players players, Awards awards) {

        return new ClimbResults(paths.getPaths().stream()
                .map(path -> ClimbResult.of(players.searchPlayerName(path.getStartIndex()), awards.searchAwardName(path.getEndIndex())))
                .collect(Collectors.toList()));

    }


    public static String getPlayerResult() {
        return InputView.getPlayerResult();
    }

    public static void showPlayerResult(ClimbResults climbResult, String player) {
        ResultView.printPlayerResult(climbResult, player);
    }
}
