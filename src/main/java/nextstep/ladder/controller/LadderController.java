package nextstep.ladder.controller;

import java.util.List;
import nextstep.ladder.domain.Ladders;
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
        List<String> participantsName = inputView.inputName();
        int height = inputView.inputHeight();
        Ladders ladders = new Ladders(height, participantsName.size());

        ladders.makeLadders();

        String ladderState = ladders.state();

        resultView.printResult(participantsName, ladderState);

    }

}
