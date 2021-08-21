package nextstep.ladders.views;

import nextstep.ladders.domain.*;


public class ConsoleOutputView {

    public static final String LINE = "-----|";
    public static final String BLANK = "     |";

    public void print(final LadderInfo ladderInfo, final Ladder ladder) {
        Participants participants = ladderInfo.getParticipants();
        ExecutionResults executionResults = ladderInfo.getExecutionResults();

        printIntro();
        printParticipants(participants);
        printLadder(ladder);
        printExecutionResults(executionResults);
    }

    private void printExecutionResults(ExecutionResults executionResults) {
        executionResults.getExecutionResult().forEach(this::printExecutionResult);
        System.out.println();
    }

    private void printExecutionResult(ExecutionResult executionResult) {
        String result = executionResult.value();
        System.out.printf("%5s ", result);
    }

    private void printIntro() {
        System.out.println("실행 결과");
        System.out.println();
    }

    private void printParticipants(Participants participants) {
        participants.getParticipants().forEach(this::printParticipant);
        System.out.println();
    }

    private void printParticipant(Participant participant) {
        String name = participant.value();
        System.out.printf("%5s ", name);
    }

    private void printLadder(Ladder ladder) {
        printLines(ladder.getLines());
    }

    private void printLines(Lines lines) {
        for (Line line : lines.getLines()) {
            printLine(line);
        }
    }

    private void printLine(Line line) {
        for (Boolean point : line.getPoints()) {
            printPoint(point);
        }
        System.out.println();
    }

    private void printPoint(Boolean point) {
        if (point) {
            System.out.print(LINE);
            return;
        }
        System.out.print(BLANK);
    }
}
