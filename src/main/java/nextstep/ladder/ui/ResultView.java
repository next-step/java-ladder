package nextstep.ladder.ui;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;


import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String BLANK = "     ";
    private static final String LINE = "-----";
    private static final String VERTICAL_LINE = "|";
    private static final String INITIAL_PADDING = "    ";
    private static final int NAME_FORMAT_LENGTH = 5;

    public static void printLadder(Ladder ladder) {
        printResultMessage();
        System.out.println(generateLadderString(ladder));
    }

    private static void printResultMessage() {
        printBlankLine();
        System.out.println(RESULT_MESSAGE);
        printBlankLine();
    }

    private static void printBlankLine() {
        System.out.println();
    }

    private static String generateLadderString(Ladder ladder) {
        StringBuilder result = new StringBuilder();
        appendParticipantNames(result, ladder.participantNames());
        appendLadderRows(result, ladder.lines(), ladder.participantCount());
        return result.toString();
    }

    private static void appendParticipantNames(StringBuilder result, List<String> names) {
        String namesRow = names.stream()
                .map(ResultView::formatName)
                .collect(Collectors.joining(" "));
        result.append(namesRow).append("\n");
    }

    private static String formatName(String name) {
        int totalWidth = NAME_FORMAT_LENGTH;
        int nameLength = name.length();
        int leftPadding = (totalWidth - nameLength) / 2;
        int rightPadding = totalWidth - nameLength - leftPadding;

        return " ".repeat(leftPadding) + name + " ".repeat(rightPadding);
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
}
