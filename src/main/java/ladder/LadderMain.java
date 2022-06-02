package ladder;

import ladder.domain.*;
import ladder.strategy.RandomLineStrategy;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderMain {
    public static void main(String[] args) {
        Participants participants = Participants.from(InputView.inputParticipantsNames());
        ExecutionResult executionResult = ExecutionResult.from(InputView.inputExecutionResult());
        Ladder ladder = LadderFactory.create(InputView.inputHeightOfLadder(), participants.count(), new RandomLineStrategy());

        ResultView.printLadderResult(participants, executionResult, ladder);
        ResultView.printExecutionResult(InputView.inputParticipantNameToSeeExecutionResult(), participants, executionResult, ladder.play());
    }
}
