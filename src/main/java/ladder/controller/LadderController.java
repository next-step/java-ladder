package ladder.controller;

import ladder.domain.RandomDraw;
import ladder.domain.Winning;
import ladder.dto.InputManagement;
import ladder.domain.Ladder;
import ladder.dto.Name;
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
        ladder.drawLine(new RandomDraw());

        Winning winning = new Winning();
        int startIndex = 0;
        for (Name name : inputManagement.getNames()) {
            winning.record(name, ladder.result(startIndex++));
        }

        ResultView resultView = new ResultView();
        resultView.print(inputManagement.getNames(), ladder.getLadder());
    }
}
