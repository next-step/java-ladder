package nextstep.ladder.view;

import nextstep.ladder.domain.*;

public class OutputView {
    private static final String EMPTY_LINE = "     |";
    private static final String DRAW_LINE = "-----|";

    public static void printLadder(LadderInputs participants, Ladder ladder) {
        printResultMention();
        printParticipants(participants);
        printLadderLines(ladder);
    }

    private static void printResultMention() {
        System.out.println();
        System.out.println("실행결과");
        System.out.println();
    }

    private static void printParticipants(LadderInputs participants) {
        for (Input input : participants.getInputs()) {
            System.out.printf("%6s", input.getInput());
        }
        System.out.println();
    }

    private static void printLadderLines(Ladder ladder) {
        for (Lines lines : ladder.getLadder()) {
            printLines(lines);
            System.out.println();
        }
    }

    private static void printLines(Lines lines) {
        for (Line line : lines.getLines()) {
            System.out.print(printHasLine(line));
        }
    }

    private static String printHasLine(Line line) {
        if (line.hasLine()) {
            return DRAW_LINE;
        }
        return EMPTY_LINE;
    }
}
