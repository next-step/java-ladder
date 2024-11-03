package nextstep.ladder.controller;

import java.util.List;
import nextstep.ladder.ladderview.InputView;
import nextstep.ladder.ladderview.ResultView;

public class LadderController {
    private final InputView inputView;
    private final ResultView resultView;

    public LadderController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        List<String> partipantsName = inputView.inputName();
        int height = inputView.inputHeight();



    }

}
