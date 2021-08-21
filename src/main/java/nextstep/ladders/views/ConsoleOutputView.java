package nextstep.ladders.views;

import nextstep.ladders.domain.*;

import java.util.List;


public class ConsoleOutputView {

    public static final String LINE = "-----|";
    public static final String BLANK = "     |";
    public static final String ALL = "all";

    public void print(final Ladder ladder, final LadderInfo ladderInfo) {
        Participants participants = ladderInfo.getParticipants();
        ExecutionResults executionResults = ladderInfo.getExecutionResults();

        introduce();
        print(participants);
        print(ladder);
        print(executionResults);
    }

    private void print(ExecutionResults executionResults) {
        executionResults.getExecutionResult().forEach(this::print);
        System.out.println();
    }

    private void print(ExecutionResult executionResult) {
        String result = executionResult.value();
        System.out.printf("%5s ", result);
    }

    private void introduce() {
        System.out.println("실행 결과");
        System.out.println();
    }

    private void print(Participants participants) {
        participants.getParticipants().forEach(this::print);
        System.out.println();
    }

    private void print(Participant participant) {
        String name = participant.value();
        System.out.printf("%5s ", name);
    }

    private void print(Ladder ladder) {
        print(ladder.getLines());
    }

    private void print(Lines lines) {
        for (Line line : lines.getLines()) {
            print(line);
        }
    }

    private void print(Line line) {
        for (Boolean point : line.getPoints()) {
            print(point);
        }
        System.out.println();
    }

    private void print(Boolean point) {
        if (point) {
            System.out.print(LINE);
            return;
        }
        System.out.print(BLANK);
    }

    public void print(final Ladder ladder, final LadderInfo ladderInfo, final String name) {
        System.out.println("실행 결과");
        if (ALL.equals(name)) {
            printAll(ladder, ladderInfo);
            return;
        }

        List<Participant> participants = ladderInfo.getParticipants().getParticipants();
        List<ExecutionResult> executionResults = ladderInfo.getExecutionResults().getExecutionResult();

        int row = participants.indexOf(Participant.valueOf(name));
        int result = ladder.start(row);

        ExecutionResult executionResult = executionResults.get(result);
        System.out.println(executionResult.value());
        System.out.println();
    }

    private void printAll(final Ladder ladder, final LadderInfo ladderInfo) {
        List<Participant> participants = ladderInfo.getParticipants().getParticipants();
        List<ExecutionResult> executionResults = ladderInfo.getExecutionResults().getExecutionResult();

        for (int row = 0; row < participants.size(); row++) {

            int result = ladder.start(row);

            Participant participant = participants.get(result);
            ExecutionResult executionResult = executionResults.get(result);

            print(participant, executionResult);
        }
    }

    private void print(Participant participant, ExecutionResult executionResult) {
        System.out.println(participant.value() + ":" + executionResult.value());
    }
}
