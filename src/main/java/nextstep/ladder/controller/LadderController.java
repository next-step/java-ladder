package nextstep.ladder.controller;

import nextstep.ladder.common.Constants;
import nextstep.ladder.entity.ladder.GameResult;
import nextstep.ladder.entity.ladder.Ladder;
import nextstep.ladder.entity.ladder.LadderResults;
import nextstep.ladder.entity.user.Users;
import nextstep.ladder.service.LadderResultService;
import nextstep.ladder.service.MultiLadderResultService;
import nextstep.ladder.service.SingleLadderResultService;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderController {

    public void start() {

        Users users = new Users(InputView.user());
        int userCount = users.userCount();

        String inputLadderResult = InputView.ladderResult();

        Ladder ladder = new Ladder(userCount, InputView.ladderHeight());

        ResultView.printLadderResult(users.userNames(), ladder);

        while (true) {
            String resultMember = InputView.resultMember();
            LadderResultService ladderResultService;

            if (resultMember.equalsIgnoreCase(Constants.RESULT_ALL_NAME)) {
                ladderResultService = new MultiLadderResultService(users);
                List<GameResult> gameResults = ladderResultService.result(new LadderResults(inputLadderResult, userCount), ladder);
                ResultView.printGameResult(gameResults);
                break;
            }

            ladderResultService = new SingleLadderResultService(resultMember, users.startPosition(resultMember));
            List<GameResult> gameResults = ladderResultService.result(new LadderResults(inputLadderResult, userCount), ladder);
            ResultView.printGameSingleResult(gameResults);

        }
    }
}
