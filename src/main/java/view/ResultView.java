package view;

import ladder.Ladder;
import ladder.LadderLine;
import ladder.LadderPlayerName;
import ladder.LadderPlayerNames;

import java.util.stream.Collectors;

public class ResultView {
    private static final String LUNCH_RESULT_TEXT = "실행결과";

    private static final String ESTABLISHED_LADDER = createLadderLineString("-");
    private static final String NOT_ESTABLISHED_LADDER = createLadderLineString(" ");
    private static final String LADDER_GUTTER = "|";

    private ResultView() {/*prevent creating instance.*/}

    public static void printLunchResult(LadderPlayerNames ladderPlayerNames, Ladder ladder) {
        System.out.println(LUNCH_RESULT_TEXT);
        System.out.println(ladderPlayerNames);
        printLadder(ladder);
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

    private static String buildLineString(LadderLine ladderLine) {
        StringBuilder builder = new StringBuilder();
        String leftBlank = String.format("%4s", " ");

        builder.append(leftBlank);

        ladderLine.getEstablishResults()
                  .stream()
                  .map(bool -> bool ? ESTABLISHED_LADDER : NOT_ESTABLISHED_LADDER)
                  .forEach(stringLine -> builder.append(LADDER_GUTTER).append(stringLine));

        builder.append(LADDER_GUTTER);

        return builder.toString();
    }
}
