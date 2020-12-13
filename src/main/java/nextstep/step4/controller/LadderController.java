package nextstep.step4.controller;

import nextstep.step4.domain.Results;
import nextstep.step4.domain.Users;
import nextstep.step4.view.InputView;

public class LadderController {

    public void start() {
        InputView inputView = new InputView();

        Users users = inputView.getUsers();
        Results results = inputView.getResults();
        int height = inputView.getHeight();

    }
}
