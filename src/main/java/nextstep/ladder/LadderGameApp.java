package nextstep.ladder;

import nextstep.ladder.controller.LadderGameController;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGameApp {
    public static void main(String[] args) {
        LadderGameController ladderGameController = new LadderGameController(new InputView(), new ResultView());
        ladderGameController.start();
    }
}
