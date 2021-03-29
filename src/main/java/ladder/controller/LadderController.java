package ladder.controller;

import ladder.dto.InputManagement;
import ladder.domain.Ladder;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    private final InputView inputView;

    public LadderController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        InputManagement inputManagement = new InputManagement(inputView.names(), inputView.height());

        Ladder ladder = new Ladder(inputManagement.getNames().size(), inputManagement.getHeight());
        ladder.drawLine();

        ResultView resultView = new ResultView();
        resultView.print(inputManagement.getNames(), ladder.getLadder());
    }
}
