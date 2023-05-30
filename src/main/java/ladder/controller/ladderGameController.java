package ladder.controller;

import ladder.view.OutputView;
import ladder.view.InputView;

public class ladderGameController {

    public static void main(String[] args) {
        OutputView.userNames();
        InputView.getStringValue();

        OutputView.ladderHeight();
        InputView.getIntValue();

        OutputView.result();
    }

}
