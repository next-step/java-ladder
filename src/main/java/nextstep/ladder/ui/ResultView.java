package nextstep.ladder.ui;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {
    private static final String LADDER_RESULT_MESSAGE = "사다리 결과";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String BLANK = "     ";
    private static final String LINE = "-----";
    private static final String VERTICAL_LINE = "|";
    private static final String COLON = " : ";
    private static final String INITIAL_PADDING = "    ";
    private static final int FORMAT_LENGTH = 5;
    private static final String PRINT_ALL_RESULT_COMMAND = "all";

    public static void printLadder(Ladder ladder) {
        printResultMessage();
        System.out.println(generateLadderString(ladder));
    }

    private static void printResultMessage() {
        printBlankLine();
        System.out.println(LADDER_RESULT_MESSAGE);
        printBlankLine();
    }

    private static void printBlankLine() {
        System.out.println();
    }

    private static String generateLadderString(Ladder ladder) {
        StringBuilder result = new StringBuilder();
        appendParticipantNames(result, ladder.participantNames());
        appendLadderRows(result, ladder.lines(), ladder.participantCount());
        appendResultRow(result, ladder.getResults());
        return result.toString();
    }

    private static void appendParticipantNames(StringBuilder result, List<String> names) {
        String namesRow = names.stream()
                .map(ResultView::formatForView)
                .collect(Collectors.joining(" "));
        result.append(namesRow).append("\n");
    }

    private static String formatForView(String text) {
        int totalWidth = FORMAT_LENGTH;
        int textLength = text.length();
        int leftPadding = (totalWidth - textLength) / 2;
        int rightPadding = totalWidth - textLength - leftPadding;

        return " ".repeat(leftPadding) + text + " ".repeat(rightPadding);
    }

    private static void appendLadderRows(StringBuilder result, List<Line> lines, int participantCount) {
        lines.forEach(line ->
                result.append(generateLadderRow(line, participantCount)).append("\n")
        );
    }

    private static String generateLadderRow(Line line, int participantCount) {
        StringBuilder builder = new StringBuilder();
        builder.append(INITIAL_PADDING);

        for (int i = 0; i < participantCount - 1; i++) {
            builder.append(VERTICAL_LINE);
            builder.append(line.points().isConnected(i) ? LINE : BLANK);
        }
        builder.append(VERTICAL_LINE);

        return builder.toString();
    }

    private static void appendResultRow(StringBuilder result, List<String> results) {
        String resultRow = results.stream()
                .map(ResultView::formatForView)
                .collect(Collectors.joining(" "));
        result.append(resultRow).append("\n");
    }

    public static void printResult(String name, Ladder ladder) {
        printBlankLine();
        if (PRINT_ALL_RESULT_COMMAND.equalsIgnoreCase(name)) {
            printAllResults(ladder.findAllResults());
            return;
        }
        System.out.println(RESULT_MESSAGE);
        System.out.println(ladder.findResult(name));
        printBlankLine();
    }

    private static void printAllResults(Map<String, String> results) {
        System.out.println(RESULT_MESSAGE);
        results.forEach((name, result) ->
                System.out.println(name + COLON + result)
        );
    }
}
