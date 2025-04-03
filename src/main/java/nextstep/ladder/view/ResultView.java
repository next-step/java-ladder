package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participant;
import nextstep.ladder.domain.Participants;


public class ResultView {

    public static void printResult(Participants participants, Ladder ladder) {
        System.out.println("실행결과");
        printParticipantNames(participants);
        printLadder(ladder);
    }

    private static void printParticipantNames(Participants participants) {
        System.out.print(" ");
        participants.getParticipants()
                .stream()
                .map(Participant::getName)
                .forEach(ResultView::printFormattedName);
        System.out.println();
    }

    private static void printFormattedName(String name) {
        System.out.print(" ".repeat(6 - name.length()) + name);
    }

    private static void printLadder(Ladder ladder) {
        ladder.getLines()
                .forEach(ResultView::printLine);
    }

    private static void printLine(nextstep.ladder.domain.Line line) {
        System.out.print(" ".repeat(6) + "|");
        line.getPoints()
                .forEach(ResultView::printPoint);
        System.out.println();
    }

    private static void printPoint(boolean point) {
        System.out.print((point ? "-" : " ").repeat(5));
        System.out.print("|");
    }
}
