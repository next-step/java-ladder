package nextstep.ladder.client;

import nextstep.ladder.controller.LadderController;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderClient {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView resultView = new OutputView();

        LadderController lottoController = new LadderController(inputView, resultView);
        lottoController.startLadder();
    }
}
