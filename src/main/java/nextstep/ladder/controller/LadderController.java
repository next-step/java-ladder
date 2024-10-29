package nextstep.ladder.controller;

import nextstep.ladder.domain.User;
import nextstep.ladder.view.InputView;

import java.util.List;

public class LadderController {
    public static void startLadderGame() {
        List<User> users = InputView.inputUsers();
        int ladderMaxHeight = InputView.inputLadderMaxHeight();
    }
}
