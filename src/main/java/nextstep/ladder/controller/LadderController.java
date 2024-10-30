package nextstep.ladder.controller;

import nextstep.ladder.view.InputView;

public class LadderController {

    public void playGame() {
        String names = InputView.readNames();
        int height = InputView.readHeight();
    }
}
