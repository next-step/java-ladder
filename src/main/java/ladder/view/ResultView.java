package ladder.view;

import ladder.domain.LadderFloor;
import ladder.domain.Participant;

import java.util.List;

public final class ResultView {
    private static final String PRINT_LINE = "-----|";
    private static final String PRINT_NO_LINE = "     |";
    private static final String FORMAT_NAME = "%6s";
    private static final String FORMAT_RESULT = "\n실행결과\n\n";


    public static void printResult(final List<Participant> participants, final List<LadderFloor> ladderFloors) {
        System.out.printf(FORMAT_RESULT);

        printNames(participants);
        printFloors(ladderFloors);
    }

    static void printNames(final List<Participant> participants) {
        participants.stream()
                .map((participant) -> participant.toStringName())
                .forEach(ResultView::printName);

        printLineFeed();
    }

    static void printName(final String name) {
        System.out.printf(String.format(FORMAT_NAME, name));
    }

    static void printFloors(final List<LadderFloor> ladderFloors) {
        ladderFloors.stream().forEach(ResultView::printFloor);
    }

    static void printFloor(final LadderFloor ladderFloor) {
        printNoLine();

        ladderFloor.getLines()
                .stream()
                .forEach(ResultView::printColumn);

        printLineFeed();
    }

    static void printColumn(final boolean line) {
        if (line == true) {
            printLine();
            return;
        }

        printNoLine();
    }

    static void printLine() {
        System.out.print(PRINT_LINE);
    }

    static void printNoLine() {
        System.out.print(PRINT_NO_LINE);
    }

    static void printLineFeed() {
        System.out.println();
    }
}
