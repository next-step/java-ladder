package ladder.view;

import ladder.domain.*;

import java.io.PrintStream;

import static ladder.view.PrintSymbol.*;

public class ResultView {

    private static final PrintStream printStream = System.out;

    private static final String RESULT_MESSAGE = "실행결과";

    private static final int SIZE = 10;
    private static final String CONNECT_STRING = buildConnectString(SIZE);
    private static final String EMPTY_STRING = buildEmptyString(SIZE);
    private static final String PRINT_PARTICIPANTS_FORMAT = "%-" + SIZE + "s";

    public static void print(Participants participants, Ladder ladder, LadderResults ladderResults) {

        printResultMessage();
        printNewLine();

        printParticipants(participants);
        printLadder(ladder);
        printLadderResults(ladderResults);
    }

    private static void printResultMessage() {

        printStream.println(RESULT_MESSAGE);
    }

    private static void printParticipants(Participants participants) {

        participants.getParticipantsName()
                .forEach(ResultView::printName);
        printNewLine();

    }

    private static void printName(String name) {

        printStream.print(String.format(PRINT_PARTICIPANTS_FORMAT, name));
    }

    private static void printLadder(Ladder ladder) {

        ladder.getLines()
                .forEach(ResultView::printLine);
    }

    private static void printLine(Line line) {

        line.getPoints()
                .forEach(ResultView::printPoint);

        printNewLine();

    }

    private static void printPoint(Point point) {

        printStream.print(STEP);
        if (Direction.RIGHT == point.getDirection()) {
            printStream.print(CONNECT_STRING);
            return;
        }
        printStream.print(EMPTY_STRING);

    }

    private static void printLadderResults(LadderResults ladderResults) {

        ladderResults.getLadderResults()
                .stream().map(LadderResult::getResult)
                .forEach(result -> printStream.print(String.format(PRINT_PARTICIPANTS_FORMAT, result)));
        printStream.println();
    }

    private static void printNewLine() {

        printStream.println();
    }

}
