package ladder;

import ladder.domain.*;
import ladder.strategy.RandomLineStrategy;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderMain {
    public static void main(String[] args) {
        String participantsNames = InputView.inputParticipantsNames();
        int numberOfLadders = InputView.inputTheNumberOfLadders();

        Participants participants = Participants.from(participantsNames);

        // TODO 실행결과 입력받기
        ExecutionResult executionResult = ExecutionResult.from(InputView.inputExecutionResult());

        List<Line> lines = LineFactory.createLines(numberOfLadders, participants.count(), new RandomLineStrategy());

        ResultView.printResult(participants, Ladder.from(lines));
    }
}
