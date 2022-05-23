package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Participants;
import ladder.domain.Point;

public class OutputView {

    private static final String PARTICIPANT_PRINT_FORMAT = "%6s";
    private static final String RESULT_INFO_MESSAGE = "실행결과";
    private static final StringBuilder LADDER_BUILDER = new StringBuilder();
    private static final String CONNECTED_LINE_STRING = "-----|";
    private static final String NOT_CONNECTED_LINE_STRING = "     |";

    private void printLadder(Ladder ladder) {
        ladder.getLines().forEach(this::appendLine);
        System.out.println(LADDER_BUILDER);
    }

    private void appendLine(Line line) {
        line.getPoints().forEach(this::appendConnection);
        LADDER_BUILDER.append("\n");
    }

    private void appendConnection(Point point) {
        if (point.isLeft()) {
            LADDER_BUILDER.append(CONNECTED_LINE_STRING);
            return;
        }
        LADDER_BUILDER.append(NOT_CONNECTED_LINE_STRING);
    }

    public void printResult(Ladder ladder, Participants participants) {
        this.printResultInfoMessage();
        this.printParticipants(participants);
        this.printLadder(ladder);
    }

    private void printResultInfoMessage() {
        System.out.println(RESULT_INFO_MESSAGE);
    }

    private void printParticipants(Participants participants) {
        participants.getParticipants()
                .forEach(participant -> System.out.printf(PARTICIPANT_PRINT_FORMAT, participant));
        System.out.println();
    }
}
