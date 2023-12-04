package ladder;

import ladder.controller.LadderController;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGame {
    public static void main(String[] args) {
        LadderController ladderController = new LadderController(new InputView(), new OutputView());
        ladderController.start();
    }
}
