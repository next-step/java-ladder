package nextstep.ladder.ui;

import nextstep.ladder.Ladder;
import nextstep.ladder.Line;
import nextstep.ladder.Names;

public class ResultView {
    private static final String NAME_FORMAT = "%6s";
    private static final String NOT_CONNECTED = "     |";
    private static final String CONNECTED = "-----|";

    public static void printLadder(Ladder ladder) {
        printNames(ladder.getNames());
        ladder.getLines().forEach(ResultView::printLine);
    }

    private static void printNames(Names names) {
        names.getNames().forEach(name -> System.out.printf(NAME_FORMAT, name));
        System.out.println();
    }

    private static void printLine(Line line) {
        System.out.print(NOT_CONNECTED);
        line.getPoints().forEach(ResultView::printPoint);
        System.out.println();
    }

    private static void printPoint(boolean connected) {
        if (connected) {
            System.out.print(CONNECTED);
            return;
        }
        System.out.print(NOT_CONNECTED);
    }
}
