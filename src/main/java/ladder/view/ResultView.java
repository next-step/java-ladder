package ladder.view;

import ladder.domain.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static ladder.domain.UserName.EMPTY_SPACE;

public class ResultView {

    public static final int NAME_PADDING = 3;

    private static final String LADDER_VERTICAL = "|";
    private static final String LADDER_HORIZONTAL = "-";
    private static int maxOutputNameLength;

    private ResultView() {
    }

    public static void printResult(LadderGame ladderGame) {
        maxOutputNameLength = ladderGame.calculateMaxNameLength() + NAME_PADDING;
        printParticipantNames(ladderGame);
        printLadderLines(ladderGame);
    }

    private static void printLadderLines(LadderGame ladderGame) {
        ladderGame.fetchLadder()
                .fetchLines()
                .forEach(line -> {
                    printLine(line, ResultView.maxOutputNameLength);
                    System.out.print(System.lineSeparator());
                });
    }

    private static void printParticipantNames(LadderGame ladderGame) {
        System.out.println(ladderGame.fetchParticipants()
                .fetchNames()
                .stream()
                .map(userName -> userName.centerAlignName(maxOutputNameLength))
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
            return LADDER_HORIZONTAL.repeat(maxOutputNameLength);
        }
        return EMPTY_SPACE.repeat(maxOutputNameLength);
    }
}
