package nextstep.ladder.controller;

import nextstep.ladder.domain.Users;
import nextstep.ladder.view.InputView;

public class LadderController {

    public void start() {
        InputView inputView = new InputView();

        Users users = new Users(inputView.inputParticipants());
    }
}
