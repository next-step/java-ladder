package nextstep.ladder;

import nextstep.ladder.controller.LadderGameController;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderRideApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        LadderGameController ladderGameController = new LadderGameController(inputView, resultView);
        ladderGameController.hintStart();
    }
}
