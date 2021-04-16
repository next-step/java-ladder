package nextstep.ladder.controller;

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

    static final String RESULT_ALL_NAME = "all";

    public void start() {

        String usersInput = InputView.user();
        String resultsInput = InputView.ladderResult();
        int ladderHeight = InputView.ladderHeight();

        Users users = new Users(usersInput);
        int userCount = users.userCount();

        Ladder ladder = new Ladder(userCount, ladderHeight);

        ResultView.printResult(users.userNames(), ladder);

        String resultMember = InputView.resultMember();

        LadderResults ladderResults = new LadderResults(resultsInput, userCount);

        LadderResultService ladderResultService = new SingleLadderResultService(users.startPosition(resultMember));

        if (resultMember.equalsIgnoreCase(RESULT_ALL_NAME)) {
            ladderResultService = new MultiLadderResultService(users);
        }

        List<String> gameResults = ladderResultService.result(ladderResults, ladder);

        ResultView.gameResult(gameResults);

    }
}
