package ladder.view;

import ladder.domain.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    private static final String LADDER_VERTICAL = "|";
    private static final String LADDER_HORIZONTAL = "-";
    private static final String EMPTY_SPACE = " ";
    private static final int NAME_PADDING = 3;
    private static int maxNameLength;

    private ResultView() {
    }

    public static void printResult(LadderGame ladderGame) {
        maxNameLength = getMaxNameLength(ladderGame);
        printParticipantNames(ladderGame);
        printLadderLines(ladderGame);
    }

    private static int getMaxNameLength(LadderGame ladderGame) {
        return ladderGame.fetchParticipants().fetchNames()
                .stream()
                .mapToInt(name -> name.fetchName().length())
                .max()
                .orElse(0) + NAME_PADDING;
    }

    private static void printLadderLines(LadderGame ladderGame) {
        ladderGame.fetchLadder()
                .fetchLines()
                .forEach(line -> {
                    printLine(line, ResultView.maxNameLength);
                    System.out.print(System.lineSeparator());
                });
    }

    private static void printParticipantNames(LadderGame ladderGame) {
        System.out.println(ladderGame.fetchParticipants()
                .fetchNames()
                .stream()
                .map(userName -> centerAlignName(userName.fetchName()))
                .collect(Collectors.joining(EMPTY_SPACE)));
    }

    private static void printLine(Line line, int maxNameLength) {
        System.out.print(EMPTY_SPACE.repeat(maxNameLength / 2) + LADDER_VERTICAL);
        String result = IntStream.range(0, line.countOfLine() - 1)
                .mapToObj(i -> getFormattedLine(line, i))
                .collect(Collectors.joining(LADDER_VERTICAL));
        System.out.printf("%s%s%s", result, LADDER_VERTICAL, EMPTY_SPACE.repeat(maxNameLength / 2));
    }

    private static String getFormattedLine(Line line, int index) {
        if (line.fetchLines().get(index)) {
            return String.format("%s%s", EMPTY_SPACE, LADDER_HORIZONTAL.repeat(maxNameLength - 1));
        }
        return EMPTY_SPACE.repeat(maxNameLength);
    }

    private static String centerAlignName(String name) {
        int leftPadding = (maxNameLength - name.length()) / 2;
        int rightPadding = maxNameLength - leftPadding - name.length();
        return String.format("%s%s%s", EMPTY_SPACE.repeat(leftPadding), name, EMPTY_SPACE.repeat(rightPadding));
    }
}
