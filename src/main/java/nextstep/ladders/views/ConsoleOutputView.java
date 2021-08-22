package nextstep.ladders.views;

import nextstep.ladders.domain.*;


public class ConsoleOutputView {

    public static final String LINE = "-----|";
    public static final String BLANK = "     |";
    public static final String ALL = "all";
    public static final String EXECUTION_RESULT = "실행 결과";

    public void print(final Ladder ladder) {

        LadderDetail ladderDetail = ladder.getLadderDetail();
        Participants participants = ladderDetail.getParticipants();
        ExecutionResults executionResults = ladderDetail.getExecutionResults();

        Lines lines = ladder.getLines();

        introduce();
        print(participants);
        print(lines);
        print(executionResults);
    }

    private void introduce() {
        System.out.println(EXECUTION_RESULT);
        System.out.println();
    }

    private void print(final Participants participants) {
        participants.getParticipants().forEach(this::print);
        System.out.println();
    }

    private void print(final Participant participant) {
        String name = participant.value();
        System.out.printf("%5s ", name);
    }

    private void print(final Lines lines) {
        for (Line line : lines.getLines()) {
            print(line);
        }
    }

    private void print(final Line line) {
        for (Boolean point : line.getPoints()) {
            print(point);
        }
        System.out.println();
    }

    private void print(final ExecutionResults executionResults) {
        executionResults.getExecutionResult().forEach(this::print);
        System.out.println();
    }

    private void print(final ExecutionResult executionResult) {
        String result = executionResult.value();
        System.out.printf("%5s ", result);
    }

    private void print(final Boolean point) {
        if (point) {
            System.out.print(LINE);
            return;
        }
        System.out.print(BLANK);
    }

    public void print(final Ladder ladder, final String name) {
        System.out.println(EXECUTION_RESULT);
        if (ALL.equals(name)) {
            printAll(ladder);
            return;
        }

        Participant participant = Participant.valueOf(name);
        ExecutionResult executionResult = ladder.start(participant);

        System.out.println(executionResult.value());
        System.out.println();
    }

    private void printAll(final Ladder ladder) {
        LadderDetail ladderDetail = ladder.getLadderDetail();
        Participants participants = ladderDetail.getParticipants();

        for (Participant participant : participants.getParticipants()) {
            ExecutionResult executionResult = ladder.start(participant);
            print(participant, executionResult);
        }
    }

    private void print(final Participant participant, final ExecutionResult executionResult) {
        System.out.println(participant.value() + " : " + executionResult.value());
    }
}
