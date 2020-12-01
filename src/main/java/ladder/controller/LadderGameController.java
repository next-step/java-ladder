package ladder.controller;

import ladder.view.InputView;

public class LadderGameController {

    public static String[] getPlayerNames() {
        return InputView.inputPlayerNames();
    }

    public static int getLadderMaxHeight() {
        return InputView.inputLadderHeight();
    }
}
