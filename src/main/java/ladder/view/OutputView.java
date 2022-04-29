package ladder.view;

import ladder.model.ExecutionResults;
import ladder.model.Ladder;
import ladder.model.Participants;
import ladder.model.Point;

import java.util.List;

public final class OutputView {

    private static final String EXECUTION_RESULT = "사다리 결과";

    private static final String PARTICIPANT_OR_RESULT_FORMAT = "%6s";

    private static final String LINE_NOT_CONNECTED_MESSAGE = "     |";
    private static final String LINE_CONNECTED_MESSAGE = "-----|";
    private static final String NEXT_LINE = "\n";

    private static final StringBuilder BUILDER = new StringBuilder();

    public void printParticipantsAndLadder(Participants participants, Ladder ladder, ExecutionResults executionResults) {
        printLadderNotifyMessage();
        printParticipants(participants);
        printLadder(ladder);
        printExecutionResults(executionResults);
    }

    private void printLadderNotifyMessage() {
        BUILDER.append(EXECUTION_RESULT);
        printMessage();
    }

    private void printParticipants(Participants participants) {
        clearBuilder();
        participants.getParticipants()
                .forEach(participant -> BUILDER.append(String.format(PARTICIPANT_OR_RESULT_FORMAT, participant)));
        printMessage();
    }

    private void printLadder(Ladder ladder) {
        clearBuilder();
        ladder.getLines().forEach(line -> appendLine(line.getPoints()));
        printMessageExceptNextLine();
    }

    private void printExecutionResults(ExecutionResults executionResults) {
        clearBuilder();
        executionResults.getExecutionResults()
                .forEach(executionResult -> BUILDER.append(String.format(PARTICIPANT_OR_RESULT_FORMAT, executionResult)));
        printMessage();
    }

    private void appendLine(List<Point> points) {
        points.forEach(this::appendConnection);
        BUILDER.append(NEXT_LINE);
    }

    private void printMessage() {
        System.out.println(BUILDER);
    }

    private void printMessageExceptNextLine() {
        System.out.print(BUILDER);
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

