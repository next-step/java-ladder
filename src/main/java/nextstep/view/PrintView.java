package nextstep.view;

import nextstep.domain.Ladder;
import nextstep.domain.Line;
import nextstep.domain.Participants;

import java.util.Arrays;

public class PrintView {

    private PrintView() {}

    public static void printResult(Participants participants, Ladder ladder, String[] gameResult) {
        printTitle();
        printParticipants(participants);
        printLadder(ladder);
        printDestination(gameResult);
    }

    private static void printDestination(String[] gameResult) {
        Arrays.stream(gameResult)
                .forEach(x -> System.out.printf("%6s", x));
    }

    private static void printTitle() {
        System.out.println("실행 결과");
    }

    private static void printParticipants(Participants participants) {
        participants.forEach(x -> System.out.printf("%6s", x));
        System.out.println();
    }

    private static void printLadder(Ladder ladder) {
        ladder.forEach(PrintView::printLine);
    }

    private static void printLine(Line line) {
        System.out.print("     |");
        line.booleanToLineStream()
                .forEach(x -> {
                    System.out.print(x);
                    System.out.print("|");
                });
        System.out.println();
    }
}
