package nextstep.ladder.controller;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Result;
import nextstep.ladder.domain.User;
import nextstep.ladder.domain.UserLadderResult;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderController {

    public static void startLadder() {
        List<User> users = InputView.getUserNames();

        List<Result> results = InputView.getResults();

        int ladderHeight = InputView.ladderHeight();

        Ladder ladder = new Ladder(ladderHeight, users.size());
        ResultView.result(ladder.getLadder(), users, results);

        users.stream().forEach(user -> user.findLastPosition(ladder));

        UserLadderResult userLadderResult = new UserLadderResult(users, results);

        InputView.printResults(userLadderResult);

    }
}
