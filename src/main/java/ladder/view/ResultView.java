package ladder.view;

import ladder.model.LadderGame;
import ladder.model.LadderLine;
import ladder.model.LadderPoint;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class ResultView {
    private static final int LADDER_WIDTH = 5;
    private static final String LADDER_RESULT_MESSAGE = "사다리 결과";
    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";
    private static final String ONE_BLANK_SPACE = " ";
    private static final String NEW_LINE = "\n";
    private static final String LADDER_LONGITUDINAL_AXIS = "|";
    private static final String LADDER_HORIZONTAL_AXIS = "-";
    private static final String COLON = ":";
    private static final PrintStream PRINT_STREAM = System.out;

    public static void printLadder(LadderGame ladderGame) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(NEW_LINE);
        stringBuilder.append(LADDER_RESULT_MESSAGE);
        stringBuilder.append(NEW_LINE);
        stringBuilder.append(NEW_LINE);
        stringBuilder.append(generateStrFittedLadderFormat(ladderGame.getPlayerNames()));
        stringBuilder.append(NEW_LINE);

        for (LadderLine line : ladderGame.getLadderLines()) {
            stringBuilder.append(generateLineResult(line));
            stringBuilder.append(NEW_LINE);
        }
        stringBuilder.append(generateStrFittedLadderFormat(ladderGame.getLadderResults()));
        stringBuilder.append(NEW_LINE);
        PRINT_STREAM.print(stringBuilder);
    }

    private static String generateStrFittedLadderFormat(List<String> items) {
        StringBuilder stringBuilder = new StringBuilder();
        int blankSpaceLength;
        for (String item : items) {
            blankSpaceLength = LADDER_WIDTH - item.length();
            stringBuilder.append(generateBlankSpace(blankSpaceLength));
            stringBuilder.append(item);
            stringBuilder.append(ONE_BLANK_SPACE);
        }
        return stringBuilder.toString();
    }

    private static String generateBlankSpace(int blankSpaceLength) {
        return Stream.generate(() -> ONE_BLANK_SPACE)
                .limit(blankSpaceLength)
                .collect(joining());
    }

    private static String generateLineResult(LadderLine line) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(generateBlankSpace(LADDER_WIDTH));
        stringBuilder.append(LADDER_LONGITUDINAL_AXIS);

        for (LadderPoint point : line.getPoints()) {
            stringBuilder.append(generatePointResult(point));
            stringBuilder.append(LADDER_LONGITUDINAL_AXIS);
        }

        int lastLadderLongitudinalAxisIndex = stringBuilder.lastIndexOf(LADDER_LONGITUDINAL_AXIS);
        stringBuilder.deleteCharAt(lastLadderLongitudinalAxisIndex);
        return stringBuilder.toString();
    }

    private static String generatePointResult(LadderPoint point) {
        if (point.isRight()) {
            return generateLadderHorizontalAxes();
        }
        return generateBlankSpace(LADDER_WIDTH);
    }

    private static String generateLadderHorizontalAxes() {
        return Stream.generate(() -> LADDER_HORIZONTAL_AXIS)
                .limit(LADDER_WIDTH)
                .collect(joining());
    }

    public static void printLadderResult(String playerLadderResult) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(NEW_LINE);
        stringBuilder.append(EXECUTION_RESULT_MESSAGE);
        stringBuilder.append(NEW_LINE);
        stringBuilder.append(playerLadderResult);
        PRINT_STREAM.println(stringBuilder);
    }

    public static void printAllLadderResult(Map<String, String> playerLadderResults) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(NEW_LINE);
        stringBuilder.append(EXECUTION_RESULT_MESSAGE);
        stringBuilder.append(NEW_LINE);

        for (String playerName : playerLadderResults.keySet()) {
            stringBuilder.append(playerName);
            stringBuilder.append(ONE_BLANK_SPACE);
            stringBuilder.append(COLON);
            stringBuilder.append(ONE_BLANK_SPACE);
            stringBuilder.append(playerLadderResults.get(playerName));
            stringBuilder.append(NEW_LINE);
        }
        PRINT_STREAM.println(stringBuilder);
    }
}
