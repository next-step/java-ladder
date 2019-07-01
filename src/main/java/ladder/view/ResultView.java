package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Participants;

import java.io.PrintStream;
import java.util.stream.IntStream;

import static ladder.view.ResultString.*;

public class ResultView {

    private static final PrintStream printStream = System.out;

    private static final String RESULT_MESSAGE = "실행결과";

    private static final int SIZE = 10;
    private static final String CONNECT_STRING = buildConnectString(SIZE);
    private static final String EMPTY_STRING = buildEmptyString(SIZE);
    private static final String PRINT_PARTICIPANTS_FORMAT = "%-" + SIZE + "s";

    public static void printResult(Participants participants, Ladder ladder) {

        printResultMessage();
        printNewLine();

        printParticipants(participants);
        printLadder(ladder);
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

        IntStream.range(0, ladder.getHeight())
                .forEach(lineNumber -> printLine(ladder, lineNumber));
    }

    private static void printLine(Ladder ladder, int lineNumber) {

        ladder.getLines().forEach(line -> {
            printStep();
            printConnect(line.getPoints().isPoint(lineNumber));
        });
        printNewLine();
    }

    private static void printStep() {

        printStream.print(STEP);
    }

    private static void printConnect(boolean isPoint) {

        if (isPoint) {
            printStream.print(CONNECT_STRING);
            return;
        }
        printEmpty();
    }

    private static void printNewLine() {

        printStream.println();
    }

    private static void printEmpty() {

        printStream.print(EMPTY_STRING);
    }

}
