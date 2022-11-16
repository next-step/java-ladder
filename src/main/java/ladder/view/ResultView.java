package ladder.view;


import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Participants;

import java.util.stream.Collectors;

public class ResultView {
    private static final String RESULT = "실행결과";
    private static final String EXIST_LINE_PART = "-----|";
    private static final String NOT_EXIST_LINE_PART = "     |";

    private ResultView() {
    }

    public static void printLadderResult(Participants participants, Ladder ladder) {
        System.out.println(RESULT);
        printMembers(participants);
        printLadder(ladder);
    }

    private static void printMembers(Participants participants) {
        participants.getParticipants()
                .forEach(participant -> System.out.printf("%5s ", participant.getName()));
        System.out.println();
    }

    private static void printLadder(Ladder ladder) {
        ladder.getLadder()
                .stream()
                .map(ResultView::printLines)
                .forEach(System.out::println);
    }

    private static String printLines(Line line) {
        return line.getPoints()
                .stream()
                .map(ResultView::getPoint)
                .collect(Collectors.joining());
    }

    private static String getPoint(boolean point) {
        if (point) {
            return EXIST_LINE_PART;
        }
        return NOT_EXIST_LINE_PART;
    }
}
