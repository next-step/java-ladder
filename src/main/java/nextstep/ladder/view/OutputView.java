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

    public static void printNamesAndLadders(LadderGame ladderGame) {
        System.out.println("실행 결과" + NEWLINE);

        String output = formatParticipantNames(ladderGame.getNames()) +
                formatLines(ladderGame.getNames().getFirstNameLength(), ladderGame.getLines());

        System.out.println(output);
    }

    public static void printInputResults(List<LadderResult> inputLadderResults) {
        System.out.println(formatLadderResults(inputLadderResults) + NEWLINE);
    }

    private static String formatParticipantNames(Names names) {
        int lastIndex = names.getNames().size() - 1;

        String strNames = names.getNames().stream()
                .limit(lastIndex)
                .map(name -> String.format(NAME_FORMAT, name.getName()))
                .collect(Collectors.joining());

        return strNames + String.format(NAME_FORMAT, names.getNames().get(lastIndex).getName()) + NEWLINE;
    }

    private static String formatLines(int firstNameLength, Lines lines) {
        return lines.getLines().stream()
                .map(line -> formatSingleLine(firstNameLength, line))
                .collect(Collectors.joining(NEWLINE)) + NEWLINE;
    }

    private static String formatSingleLine(int firstNameLength, Line line) {
        StringBuilder ladder = new StringBuilder(LADDER_SPACE.repeat(firstNameLength) + LADDER_VERTICAL_LINE);

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
