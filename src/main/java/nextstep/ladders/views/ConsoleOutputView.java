package nextstep.ladders.views;

import nextstep.ladders.*;

import java.util.List;

public class ConsoleOutputView {

    public static final String LINE = "-----|";
    public static final String BLANK = "     |";
    public static final String ALL = "all";
    public static final String EXECUTION_RESULT = "실행 결과";

    public void print(final LadderGame ladderGame, final Ladder ladder) {
        introduce();
        print(ladderGame.getParticipants());
        print(ladder.getLines());
        print(ladderGame.getExecutionResults());
    }

    private void introduce() {
        System.out.println(EXECUTION_RESULT);
        System.out.println();
    }

    private void print(final Participants participants) {
        participants.elements().forEach(this::print);
        System.out.println();
    }

    private void print(final Participant participant) {
        String name = participant.value();
        System.out.printf("%5s ", name);
    }

    private void print(final Lines lines) {
        for (Line line : lines.elements()) {
            print(line);
        }
    }

    private void print(final Line line) {
        for (Point point : line.elements()) {
            print(point);
        }
        System.out.println();
    }

    private void print(final ExecutionResults executionResults) {
        executionResults.elements().forEach(this::print);
        System.out.println();
    }

    private void print(final ExecutionResult executionResult) {
        String result = executionResult.value();
        System.out.printf("%5s ", result);
    }

    private void print(final Point point) {
        Direction direction = point.getDirection();
        if (direction.isLeft()) {
            System.out.print(LINE);
            return;
        }
        System.out.print(BLANK);
    }

    public void print(final LadderGame ladderGame, final Ladder ladder, final String name) {
        System.out.println(EXECUTION_RESULT);

        if (ALL.equals(name)) {
            printAll(ladderGame, ladder);
            return;
        }

        Participants participants = ladderGame.getParticipants();
        List<Participant> participantList = participants.elements();

        ExecutionResults executionResults = ladderGame.getExecutionResults();
        List<ExecutionResult> executionResultList = executionResults.elements();

        Participant participant = Participant.valueOf(name);
        int participantIndex = participantList.indexOf(participant);
        int executionResultIndex = ladder.start(participantIndex);
        ExecutionResult executionResult = executionResultList.get(executionResultIndex);

        System.out.println(executionResult.value());
        System.out.println();
    }

    private void printAll(final LadderGame ladderGame, final Ladder ladder) {
        Participants participants = ladderGame.getParticipants();
        ExecutionResults executionResults = ladderGame.getExecutionResults();

        List<Participant> participantList = participants.elements();
        List<ExecutionResult> executionResultList = executionResults.elements();

        for (int i = 0; i < participantList.size(); i++) {

            Participant participant = participantList.get(i);
            int executionResultIndex = ladder.start(i);
            ExecutionResult executionResult = executionResultList.get(executionResultIndex);

            print(participant, executionResult);
        }
    }

    private void print(final Participant participant, final ExecutionResult executionResult) {
        System.out.println(participant.value() + " : " + executionResult.value());
    }
}
