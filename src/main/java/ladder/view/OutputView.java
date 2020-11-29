package ladder.view;

import ladder.domain.ladder.LadderLine;
import ladder.domain.ladder.Point;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String MAIN_TITLE = "사다리 결과";
    private static final String RESULT_TITLE = "실행 결과";
    private static final String USER_NAME_FORMAT = "%6s";
    private static final String PRIZE_NAME_FORMAT = "%6s";
    private static final String RIGHT_LADDER_LINE = "|-----";
    private static final String NO_LADDER_LINE = "|     ";
    private static final String INIT_SPACE = "     ";
    private static final String DELIMITER = " : ";

    public static void printLadderViewResult(final List<String> userNames, final List<LadderLine> ladderLines, final List<String> prizeNames) {
        printTitle();
        printUserNames(userNames);
        printLadder(ladderLines);
        printPrize(prizeNames);
    }

    private static void printTitle() {
        Printer.printNewLine();
        Printer.print(MAIN_TITLE);
        Printer.printNewLine(2);
    }

    private static void printUserNames(final List<String> userNames) {
        userNames.stream()
                .map(name -> String.format(USER_NAME_FORMAT, name))
                .forEach(Printer::print);
        Printer.printNewLine();
    }

    private static void printLadder(final List<LadderLine> ladderLines) {
        ladderLines.forEach(OutputView::printLine);
    }

    private static void printLine(final LadderLine ladderLine) {
        final List<Point> points = ladderLine.getPoints();
        Printer.print(INIT_SPACE);
        points.forEach(OutputView::printOneLine);
        Printer.printNewLine();
    }

    private static void printOneLine(final Point point) {
        if (point.hasRight()) {
            Printer.print(RIGHT_LADDER_LINE);
            return;
        }
        Printer.print(NO_LADDER_LINE);
    }

    private static void printPrize(final List<String> prizeNames) {
        prizeNames.stream()
                .map(name -> String.format(PRIZE_NAME_FORMAT, name))
                .forEach(Printer::print);
        Printer.printNewLine();
    }

    public static void printUserResult(final Map<String, String> ladderGameResult, final String userName) {
        Printer.printNewLine();
        Printer.println(RESULT_TITLE);
        Printer.println(ladderGameResult.get(userName));
    }

    public static void printAllUserResult(final Map<String, String> ladderGameResult) {
        Printer.printNewLine();
        Printer.println(RESULT_TITLE);
        for (final String userName : ladderGameResult.keySet()) {
            Printer.println(userName + DELIMITER + ladderGameResult.get(userName));
        }
    }
}
