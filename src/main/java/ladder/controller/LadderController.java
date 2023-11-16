package ladder.controller;

import ladder.domain.Names;
import ladder.view.InputView;

public class LadderController {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        Names names = new Names(inputView.names());
        int ladderHeight = inputView.ladderHeight();
    }

}
