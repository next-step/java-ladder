package ladder.view;

import ladder.domain.LadderLine;
import ladder.domain.Point;

import java.util.List;

public class OutputView {
    private static final String TITLE = "사다리 결과";
    private static final String USER_NAME_FORMAT = "%6s";
    private static final String PRIZE_NAME_FORMAT = "%6s";
    private static final String RIGHT_LADDER_LINE = "|-----";
    private static final String NO_LADDER_LINE = "|     ";
    private static final String INIT_SPACE = "     ";

    public static void printLadderViewResult(final List<String> userNames, final List<LadderLine> ladderLines, final List<String> prizeNames) {
        printTitle();
        printUserNames(userNames);
        printLadder(ladderLines);
        printPrize(prizeNames);
    }

    private static void printTitle() {
        Printer.printNewLine();
        Printer.print(TITLE);
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
}
