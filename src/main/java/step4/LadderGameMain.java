package step4;

import step4.controller.LadderGameController;
import step4.view.InputView;

public class LadderGameMain {
    public static void main(String[] args) {
        LadderGameController ladderController = new LadderGameController(InputView.inputPlayerNames(),
            InputView.inputResultPrizes(),
            InputView.inputMaxLadderHeight());

        ladderController.play();
    }
}
