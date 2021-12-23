package nextstep.ladder;

import nextstep.ladder.controller.LadderController;
import nextstep.ladder.controller.RunRequest;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderApplication {
    public static void main(String[] args) {
        LadderController controller = new LadderController();
        RunRequest request = RunRequest.of(InputView.readParticipantNames(), InputView.readHeightOfLadder());
        String executionResult = InputView.readExecutionResult();// todo: 사다리 실행 결과 로직 구현
        OutputView.printLadderResult(request.participatedUsers(), controller.run(request));
    }
}
