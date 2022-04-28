package ladder.view;

import ladder.model.Line;
import ladder.model.Participant;
import ladder.model.Point;

import java.util.List;

public final class OutputView {

    private static final String EXECUTION_RESULT = "사다리 결과";

    private static final String PARTICIPANT_FORMAT = "%6s";

    private static final String LINE_NOT_CONNECTED_MESSAGE = "     |";
    private static final String LINE_CONNECTED_MESSAGE = "-----|";
    private static final String NEXT_LINE = "\n";

    private static final StringBuilder BUILDER = new StringBuilder();

    public void printParticipantsAndLadder(List<Participant> participants, List<Line> lines) {
        printExecutionResult();
        printParticipants(participants);
        printLadder(lines);
    }

    private void printExecutionResult() {
        BUILDER.append(EXECUTION_RESULT);
        printMessage();
    }

    private void printParticipants(List<Participant> participants) {
        clearBuilder();
        participants.forEach(participant -> BUILDER.append(String.format(PARTICIPANT_FORMAT, participant)));
        printMessage();
    }

    private void printLadder(List<Line> lines) {
        clearBuilder();
        lines.forEach(line -> appendLine(line.getPoints()));
        printMessage();
    }

    private void appendLine(List<Point> points) {
        points.forEach(this::appendConnection);
        BUILDER.append(NEXT_LINE);
    }

    private void printMessage() {
        System.out.println(BUILDER);
    }

    private void appendConnection(Point point) {
        if (point.isLeft()) {
            BUILDER.append(LINE_CONNECTED_MESSAGE);
            return;
        }
        BUILDER.append(LINE_NOT_CONNECTED_MESSAGE);
    }

    private void clearBuilder() {
        BUILDER.setLength(0);
    }

}

