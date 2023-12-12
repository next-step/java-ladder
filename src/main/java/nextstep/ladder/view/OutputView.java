package nextstep.ladder.view;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Names;

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
}
