package ladder.view;

import ladder.domain.*;

import static ladder.utils.LadderUtil.fillSpace;

public class ResultView {

    public static final String POINT_TRUE = "-----|";
    public static final String POINT_FALSE = "     |";

    private ResultView() {}

    public static void printLadder(Participants participants, Ladder ladder, Results results) {
        System.out.println("\n사다리 결과\n");
        printParticipants(participants);
        for (Line line : ladder.getLadder()) {
            printLadderPoint(line);
            System.out.println();
        }
        printResults(results);
    }

    private static void printParticipants(Participants participants) {
        participants.getParticipants().stream()
                .map(person -> fillSpace(person.getName()))
                .forEach(System.out::print);
        System.out.println();
    }

    private static void printLadderPoint(Line line) {
        line.getPoints().stream()
                .map(point -> drawLine(point))
                .forEach(System.out::print);
    }

    private static String drawLine(Point point) {
        if (point.isPoint()) {
            return POINT_TRUE;
        }
        return POINT_FALSE;
    }

    private static void printResults(Results results) {
        results.getResults().stream()
                .map(result -> fillSpace(result.getResult()))
                .forEach(System.out::print);
    }
}
