package ladder.controller;

import ladder.model.*;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {

    private final DirectionGenerator directionGenerator = new RandomDirectionGenerator();

    public void run() {
        Names names = new Names(InputView.inputNames());
        Ladder ladder = new Ladder(names.size(), InputView.inputHeight(), directionGenerator);

        OutputView.printLadderResult(new LadderResult(names, ladder));
    }
}
