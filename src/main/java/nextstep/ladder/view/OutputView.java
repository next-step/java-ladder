package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String NAME_FORMAT = "%5s ";
    private static final String LADDER_HORIZONTAL_LINE = "-----";
    private static final String LADDER_EMPTY_SPACE = "     ";
    private static final String LADDER_VERTICAL_LINE = "|";
    private static final String LADDER_SPACE = " ";
    private static final String NEWLINE = System.lineSeparator();
    private static final int MAX_NAME_LENGTH = 5;

    public static void printInputResults(List<LadderResult> inputLadderResults) {
        System.out.println(formatLadderResults(inputLadderResults) + NEWLINE);
    }

    public static void printNames(Names names) {
        String strNames = names.getNames().stream()
                .map(name -> String.format(NAME_FORMAT, name.getName()))
                .collect(Collectors.joining());

        System.out.println(strNames);
    }

    public static void printLadders(Lines lines) {
        System.out.println(formatLines(lines));
    }

    private static String formatLines(Lines lines) {
        return lines.getLines().stream()
                .map(OutputView::formatSingleLine)
                .collect(Collectors.joining(NEWLINE));
    }

    private static String formatSingleLine(Line line) {
        StringBuilder ladder = new StringBuilder(LADDER_SPACE.repeat(MAX_NAME_LENGTH) + LADDER_VERTICAL_LINE);

        line.getPoints().stream()
                .map(point -> point ? LADDER_HORIZONTAL_LINE : LADDER_EMPTY_SPACE)
                .forEach(segment -> ladder.append(segment).append(LADDER_VERTICAL_LINE));

        return ladder.toString();
    }
    private static String formatLadderResults(List<LadderResult> inputLadderResults) {
        return inputLadderResults.stream()
                .map(ladderResult -> String.format(NAME_FORMAT, ladderResult.getResult()))
                .collect(Collectors.joining());
    }
}
