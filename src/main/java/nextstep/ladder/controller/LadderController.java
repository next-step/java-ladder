package nextstep.ladder.controller;

import nextstep.ladder.common.Constants;
import nextstep.ladder.entity.ladder.Ladder;
import nextstep.ladder.entity.ladder.LadderResults;
import nextstep.ladder.entity.user.Users;
import nextstep.ladder.service.MultiLadderResultService;
import nextstep.ladder.service.SingleLadderResultService;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderController {

    public void start() {

        Users users = new Users(InputView.user());
        int userCount = users.userCount();

        String inputLadderResult = InputView.ladderResult();

        Ladder ladder = new Ladder(userCount, InputView.ladderHeight());

        ResultView.printLadderResult(users.userNames(), ladder);
        ResultView.printReward(inputLadderResult);

        while (true) {
            String resultMember = InputView.resultMember();

            if (resultMember.equalsIgnoreCase(Constants.RESULT_ALL_NAME)) {
                ResultView.printAllUserGameResult(new MultiLadderResultService(users).result(new LadderResults(inputLadderResult, userCount), ladder));
                break;
            }

            ResultView.printSingleUserGameResult(new SingleLadderResultService(resultMember, users.startPosition(resultMember))
                    .result(new LadderResults(inputLadderResult, userCount), ladder));

        }
    }
}
