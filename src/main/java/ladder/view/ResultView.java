package ladder.view;

import ladder.Ladder;
import ladder.LadderLine;
import ladder.LadderPlayerName;
import ladder.LadderPlayerNames;
import ladder.LadderResult;
import ladder.LadderReward;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    private static final String LUNCH_RESULT_TEXT = "사다리 결과";
    private static final String REWARD_RESULT_TEXT = "실행 결과";

    private static final String ESTABLISHED_LADDER = createLadderLineString("-");
    private static final String NOT_ESTABLISHED_LADDER = createLadderLineString(" ");
    private static final String LADDER_GUTTER = "|";

    private ResultView() {/*prevent creating instance.*/}

    public static void printLunchResult(LadderPlayerNames ladderPlayerNames, Ladder ladder) {
        System.out.println(LUNCH_RESULT_TEXT);
        System.out.println(ladderPlayerNames);
        printLadder(ladder);
        int countOfPerson = ladderPlayerNames.countOfPerson();
        printLadderRewards(countOfPerson, ladder);
    }

    public static void printRewardResult(List<LadderResult> results) {
        if (results.size() == 0) {
            return;
        }
        System.out.println();
        System.out.println(REWARD_RESULT_TEXT);
        if (results.size() == 1) {
            printLadderResult(results.get(0));
        } else {
            printLadderResults(results);
        }
    }

    private static String createLadderLineString(String lineString) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < LadderPlayerName.MAX_PLAYER_NAME_LENGTH; i++) {
            builder.append(lineString);
        }

        return builder.toString();
    }

    private static void printLadder(Ladder ladder) {
        String ladderText = ladder.getLadderLines().stream()
                                  .map(ResultView::buildLineString)
                                  .collect(Collectors.joining("\n"));

        System.out.println(ladderText);
    }

    private static void printLadderRewards(int countOfPerson, Ladder ladder) {
        String ladderRewardsText = IntStream.range(0, countOfPerson)
                                            .mapToObj(ladder::getReward)
                                            .map(LadderReward::getText)
                                            .map(name -> String.format("%5s", name))
                                            .collect(Collectors.joining(" "));
        System.out.println(ladderRewardsText);
    }

    private static String buildLineString(LadderLine ladderLine) {
        StringBuilder builder = new StringBuilder();
        String leftBlank = String.format("%4s", " ");

        builder.append(leftBlank);

        ladderLine.getEstablishResults()
                  .stream()
                  .map(lineState -> lineState == LadderLine.LineState.ESTABLISH ? ESTABLISHED_LADDER : NOT_ESTABLISHED_LADDER)
                  .forEach(stringLine -> builder.append(LADDER_GUTTER).append(stringLine));

        builder.append(LADDER_GUTTER);

        return builder.toString();
    }

    private static void printLadderResults(List<LadderResult> results) {
        String resultText = results.stream()
                                   .map(ResultView::buildLadderResultText)
                                   .collect(Collectors.joining("\n"));
        System.out.println(resultText);
    }

    private static String buildLadderResultText(LadderResult result) {
        String playerName = result.getPlayerName();
        String ladderRewardText = result.getLadderReward().getText();
        return String.format("%s : %s", playerName, ladderRewardText);
    }

    private static void printLadderResult(LadderResult result) {
        LadderReward ladderReward = result.getLadderReward();
        String ladderRewardText = ladderReward.getText();
        System.out.println(ladderRewardText);
    }
}
