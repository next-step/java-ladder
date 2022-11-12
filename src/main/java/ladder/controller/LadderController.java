package ladder.controller;

import ladder.model.*;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {

    private final DirectionGenerator directionGenerator = new RandomDirectionGenerator();

    public void run() {
        Users users = new Users(InputView.inputNames());
        Ladder ladder = new Ladder(users.size(), InputView.inputHeight(), directionGenerator);

        OutputView.printLadderResult(new LadderResult(users, ladder));
    }
}
