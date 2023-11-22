package nextstep.ladder.controller;

import nextstep.ladder.controller.dto.GameInfo;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGameController {

    private InputView inputView;
    private ResultView resultView;

    public LadderGameController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void start() {
        String[] names = inputView.inputPlayerName();
        int height = inputView.inputHeight();
        GameInfo gameInfo = new GameInfo(names, height);
    }
}
