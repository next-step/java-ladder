package ladder.view;

import java.util.List;

import ladder.model.Ladder;
import ladder.model.Line;
import ladder.model.Participant;
import ladder.model.Point;

public final class OutputView {
    public static final String MARK_OF_POINT = "|";
    public static final String MARK_OF_EMPTY_LINE = " ";
    public static final String MARK_OF_CONNECTED_LINE = "-";

    public static void printLadder(Ladder ladder) {
        final List<Line> lines = ladder.getLines();
        lines.forEach(OutputView::printLine);
    }

    private OutputView() {}

    private static void printLine(Line line) {
        printWhiteSpace();
        final List<Point> points = line.getPoints();

        points.forEach(OutputView::printPoint);
        printReturnLine();
    }

    private static void printReturnLine() {
        System.out.println();
    }

    private static void printWhiteSpace() {
        for (int i = 0; i < Participant.MAX_LENGTH; i++) {
            System.out.print(MARK_OF_EMPTY_LINE);
        }
    }

    public static void printPoint(Point point) {
        if (point.isConnectedRight()) {
            printConnectedPoint();
            return;
        }
        printUnconnectedPoint();
    }

    private static void printUnconnectedPoint() {
        System.out.print(MARK_OF_POINT);
        for (int i = 0; i < Participant.MAX_LENGTH; i++) {
            System.out.print(MARK_OF_EMPTY_LINE);
        }
    }

    private static void printConnectedPoint() {
        System.out.print(MARK_OF_POINT);
        for (int i = 0; i < Participant.MAX_LENGTH; i++) {
            System.out.print(MARK_OF_CONNECTED_LINE);
        }
    }
}
