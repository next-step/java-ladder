package nextstep.ladder.view.output;

import nextstep.ladder.domain.executionresult.ExecutionResult;
import nextstep.ladder.domain.ladder.Ladders;
import nextstep.ladder.domain.participant.Participants;

public class OutputView {

    public static final String NEW_LINE = System.lineSeparator();

    private final ParticipantsOutputView participantsOutputView = new ParticipantsOutputView();
    private final LaddersOutputView laddersOutputView = new LaddersOutputView();
    private final ExecutionResultView executionResultView = new ExecutionResultView();

    public void printParticipants(Participants participants) {
        StringBuilder stringBuilder = new StringBuilder();
        appendTitle(stringBuilder);
        participantsOutputView.appendParticipantsName(participants, stringBuilder);
        print(stringBuilder.toString());
    }

    private void appendTitle(StringBuilder stringBuilder) {
        stringBuilder.append("실행결과");
        stringBuilder.append(NEW_LINE);
        stringBuilder.append(NEW_LINE);
    }

    public void printLadders(Ladders ladders) {
        StringBuilder stringBuilder = new StringBuilder();
        laddersOutputView.appendLadders(ladders, stringBuilder);
        print(stringBuilder.toString());
    }

    public void printExecutionResult(ExecutionResult result) {
        StringBuilder stringBuilder = new StringBuilder();
        executionResultView.appendExecutionResult(result, stringBuilder);
        print(stringBuilder.toString());
    }

    public void print(String content) {
        System.out.println(content);
    }
}
