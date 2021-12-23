package nextstep.ladder;

import nextstep.ladder.controller.LadderController;
import nextstep.ladder.controller.RunRequest;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.List;

public class LadderApplication {
    public static void main(String[] args) {
        LadderController controller = new LadderController();
        List<String> userNames = InputView.readParticipantNames();
        String executionResult = InputView.readExecutionResult();// todo: 사다리 실행 결과 로직 구현
        RunRequest request = RunRequest.of(userNames, InputView.readHeightOfLadder());
        OutputView.printLadderResult(request.participatedUsers(), controller.run(request));
        OutputView.printExecutionResultForUsers(InputView.readCommandForResultOfTargetUser());// todo: 반복 실행 결과 확인 로직 구현
    }
}
