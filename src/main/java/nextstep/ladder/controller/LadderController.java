package nextstep.ladder.controller;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Users;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderController {

    public static void startLadder() {
        Users users = InputView.name();

        int ladderHeight = InputView.ladderHeight();

        Ladder ladder = new Ladder(ladderHeight, users.userCount());
        ResultView.result(ladder.getLadder(), users);
    }
}
