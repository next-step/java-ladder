package nextstep.view;

import nextstep.domain.*;

import java.util.Arrays;
import java.util.Map;

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
        System.out.println();
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

    public static void printFinalResult(String participant, Record record) {
        Map<Participant, String> finalResult = record.value(participant);
        finalResult.forEach((x, y) -> System.out.println(x + ":" + y));
    }
}
