package nextstep.ladder.controller;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.UserName;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderController {

    public static void startLadder() {
        List<UserName> userNames = InputView.getUserNames();

        int ladderHeight = InputView.ladderHeight();

        Ladder ladder = new Ladder(ladderHeight, userNames.size());
        ResultView.result(ladder.getLadder(), userNames);
    }
}
