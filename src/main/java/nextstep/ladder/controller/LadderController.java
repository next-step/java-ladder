package nextstep.ladder.controller;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.User;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderController {

    public static void startLadder() {
        List<User> users = InputView.getUserNames();

        List<String> results = InputView.getResults();

        int ladderHeight = InputView.ladderHeight();

        Ladder ladder = new Ladder(ladderHeight, users.size());
        ResultView.result(ladder.getLadder(), users, results);

        users.stream().forEach(user -> user.findLastPosition(ladder));

        InputView.printResults(users, results);

    }
}
