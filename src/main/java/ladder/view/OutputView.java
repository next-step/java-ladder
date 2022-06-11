package ladder.view;

import ladder.domain.*;
import ladder.dto.LadderResultDto;

import java.util.List;

public class OutputView {

    private static final String PARTICIPANT_PRINT_FORMAT = "%6s";
    private static final String RESULT_INFO_MESSAGE = "실행결과";
    private static final StringBuilder LADDER_BUILDER = new StringBuilder();
    private static final String CONNECTED_LINE_STRING = "-----|";
    private static final String NOT_CONNECTED_LINE_STRING = "     |";
    private static final String PRINT_EXECUTION_RESULT_FORMAT = "%s : %s\n";
    private static final String RESULT_EXECUTION_INFO_MESSAGE = "실행 결과";
    private static final String TOW_LINE_BREAK = "\n\n";
    private static final String ONE_LINE_BREAK = "\n";

    private void printLadder(Ladder ladder) {
        this.printLines(ladder.getLines());
    }

    private void printLines(List<Line> lines) {
        lines.forEach(this::appendLine);
        System.out.print(LADDER_BUILDER);
    }

    private void appendLine(Line line) {
        line.getPoints().forEach(this::appendConnection);
        LADDER_BUILDER.append(ONE_LINE_BREAK);
    }

    private void appendConnection(Point point) {
        if (point.isLeft()) {
            LADDER_BUILDER.append(CONNECTED_LINE_STRING);
            return;
        }
        LADDER_BUILDER.append(NOT_CONNECTED_LINE_STRING);
    }

    public void printLadder(Ladder ladder, Participants participants, ExecutionResults executionResults) {
        this.printResultInfoMessage();
        this.printParticipants(participants);
        this.printLadder(ladder);
        this.printExecutionResults(executionResults);
    }

    public void printAllParticipantResults(LadderResultDto ladderResultDto) {
        printResultExecutionInfoMessage();
        ladderResultDto.getResults().forEach(this::printExecutionResultPerParticipant);
    }

    public void printParticipantResult(LadderResultDto ladderResultDto, String participantForResult) {
        printResultExecutionInfoMessage();
        ExecutionResult executionResult = ladderResultDto.showLadderResult(participantForResult);
        printExecutionResultPerParticipant(participantForResult, executionResult);
    }

    private void printResultExecutionInfoMessage() {
        System.out.println(RESULT_EXECUTION_INFO_MESSAGE);
    }

    private void printExecutionResultPerParticipant(String participantName, ExecutionResult executionResult) {
        System.out.printf(PRINT_EXECUTION_RESULT_FORMAT, participantName, executionResult.toString());
    }

    private void printExecutionResults(ExecutionResults executionResults) {
        executionResults.getExecutionResults()
                .forEach(participant -> System.out.printf(PARTICIPANT_PRINT_FORMAT, participant));
        System.out.print(TOW_LINE_BREAK);
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
