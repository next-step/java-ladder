package ladder.view;

import ladder.domain.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static ladder.domain.UserName.EMPTY_SPACE;

public class ResultView {

    public static final int NAME_PADDING = 3;
    public static final String LADDER_VERTICAL = "|";
    public static final String LADDER_HORIZONTAL = "-";

    private ResultView() {
    }

    public static void printResult(LadderGame ladderGame) {
        int maxOutputNameLength = ladderGame.calculateMaxNameLength() + NAME_PADDING;
        System.out.println(ladderGame.formatCenterAlignedParticipantNames(maxOutputNameLength));
        printLadder(ladderGame, maxOutputNameLength);
    }

    private static void printLadder(LadderGame ladderGame, int maxOutputNameLength) {
        ladderGame.fetchLadder()
                .fetchLines()
                .forEach(line -> {
                    printLine(line, maxOutputNameLength);
                    System.out.print(System.lineSeparator());
                });
    }

    private static void printLine(Line line, int maxOutputNameLength) {
        System.out.print(EMPTY_SPACE.repeat(maxOutputNameLength / 2) + LADDER_VERTICAL);
        String result = IntStream.range(0, line.countOfLine() - 1)
                .mapToObj(i -> line.determineFormattedLinePart(i, maxOutputNameLength))
                .collect(Collectors.joining(LADDER_VERTICAL));
        System.out.printf("%s%s%s", result, LADDER_VERTICAL, EMPTY_SPACE.repeat(maxOutputNameLength / 2));
    }
}
