package ladder2;

import ladder2.controller.LadderController;
import ladder2.view.InputView;
import ladder2.view.OutputView;

public class LadderGame {
    public static void main(String[] args) {
        LadderController ladderController = new LadderController(new InputView(), new OutputView());
        ladderController.start();
    }
}
