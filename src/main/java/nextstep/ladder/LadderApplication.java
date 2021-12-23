package nextstep.ladder;

import nextstep.ladder.controller.LadderController;
import nextstep.ladder.controller.RunRequest;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.List;

public class LadderApplication {
    public static void main(String[] args) {
        LadderController controller = new LadderController();
        List<String> executionResult = InputView.readExecutionResults();// todo: 사다리 실행 결과 로직 구현
        RunRequest request = RunRequest.of(userNames, InputView.readHeightOfLadder());
        OutputView.printLadderResult(request.participatedUsers(), controller.run(request));
        Users users = Users.from(InputView.readUserNames());
        Ladder ladder = controller.createLadder(RunRequest.of(users.size(), InputView.readHeightOfLadder()));
        OutputView.printLadderResult(users, ladder);
        OutputView.printExecutionResultForUsers(InputView.readCommandForResultOfTargetUser());// todo: 반복 실행 결과 확인 로직 구현
    }
}
