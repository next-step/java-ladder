package laddergame.io;

import laddergame.ui.InputView;
import laddergame.ui.ResultView;

public class LadderGameIOHandler {
    private final InputView inputView;
    private final ResultView resultView;

    public LadderGameIOHandler(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public InputView getInputView() {
        return inputView;
    }

    public ResultView getResultView() {
        return resultView;
    }
}
