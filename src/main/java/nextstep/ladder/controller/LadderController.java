package nextstep.ladder.controller;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.User;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderController {
    public static void startLadderGame() {
        List<User> users = InputView.inputUsers();
        int ladderMaxHeight = InputView.inputLadderMaxHeight();

        Ladder ladder = new Ladder(users.size(), ladderMaxHeight);

        ResultView.printResult(ladder, users);
    }
}
