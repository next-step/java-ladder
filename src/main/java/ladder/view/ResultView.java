package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Participants;

import static ladder.utils.LadderUtil.fillSpace;

public class ResultView {

    public static final String POINT_TRUE = "-----|";
    public static final String POINT_FALSE = "     |";

    private ResultView() {
    }

    public static void printLadder(Participants participants, Ladder ladder) {
        System.out.println("실행결과\n");

        printParticipants(participants);
        System.out.println();

        for (Line line : ladder.getLadder()) {
            printLadderPoint(line);
            System.out.println();
        }
    }

    private static void printParticipants(Participants participants) {
        participants.getParticipants().stream()
                .map(person -> fillSpace(person.getName()))
                .forEach(System.out::print);
    }

    private static void printLadderPoint(Line line) {
        line.getPoints().stream()
                .map(point -> {
                    if (point.isPoint()) {
                        return POINT_TRUE;
                    }
                    return POINT_FALSE;
                }).forEach(System.out::print);
    }


}
