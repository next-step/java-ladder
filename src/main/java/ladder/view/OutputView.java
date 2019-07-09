package ladder.view;

import java.util.List;

import ladder.model.Ladder;
import ladder.model.Line;
import ladder.model.Participant;
import ladder.model.Participants;
import ladder.model.Point;

public final class OutputView {
    private static final String MARK_OF_POINT = "|";
    private static final String MARK_OF_EMPTY_LINE = " ";
    private static final String MARK_OF_CONNECTED_LINE = "-";
    private static final String FORMAT_OF_NAME = "%6s";

    public static void printResult(Participants participants, Ladder ladder) {
        System.out.println("사다리 결과\n");
        printParticipants(participants);
        printReturnLine();
        printLadder(ladder);
    }

    private OutputView() {}

    private static void printParticipants(Participants participants) {
        participants.getParticipants()
                    .stream()
                    .map(Participant::getName)
                    .forEach(OutputView::printName);
    }

    private static void printLadder(Ladder ladder) {
        final List<Line> lines = ladder.getLines();
        lines.forEach(OutputView::printLine);
    }

    private static void printLine(Line line) {
        printWhiteSpace();
        final List<Point> points = line.getPoints();

        points.forEach(OutputView::printPoint);
        printReturnLine();
    }

    private static void printWhiteSpace() {
        for (int i = 0; i < Participant.MAX_LENGTH; i++) {
            System.out.print(MARK_OF_EMPTY_LINE);
        }
    }

    private static void printPoint(Point point) {
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

    private static void printName(String name) {
        System.out.print(String.format(FORMAT_OF_NAME, name));
    }

    private static void printReturnLine() {
        System.out.println();
    }
}
