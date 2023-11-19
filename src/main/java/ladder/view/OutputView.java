package ladder.view;

import ladder.domain.Line;
import ladder.domain.Ladder;
import ladder.domain.Name;
import ladder.domain.Names;
import ladder.domain.Point;

import java.util.List;

public class OutputView {

    private static final String RESULT_MESSAGE = "실행결과";
    private static final String LINE_DIVISION = "|";
    private static final String PRINT_NAME = "%6s";
    private static final String BLANK = "      ";
    private static final String HORIZONTAL_LINE = "-----";
    private static final String NONE_LINE = "     ";

    private OutputView() {
    }

    public static void printLadder(Names names, Ladder ladder) {
        System.out.println(RESULT_MESSAGE);

        printNames(names);
        printLines(ladder.getLines());
    }

    private static void printNames(Names names) {
        names.getNames()
                .forEach(name -> System.out.printf(PRINT_NAME, name));
        System.out.println();
    }

    private static void printLines(List<Line> lines) {
        lines.forEach(OutputView::printLine);
    }

    private static void printLine(Line line) {
        System.out.print(BLANK + LINE_DIVISION);

        line.getPoints()
                .forEach(OutputView::printPoint);

        System.out.println();
    }

    private static void printPoint(Point point) {
        if (point.canDraw()) {
            System.out.print(HORIZONTAL_LINE + LINE_DIVISION);
            return;
        }
        System.out.print(NONE_LINE + LINE_DIVISION);
    }
}
