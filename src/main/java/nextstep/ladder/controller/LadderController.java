package nextstep.ladder.controller;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderController {

    private final InputView inputView;
    private final ResultView resultView;

    public LadderController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void execute() {
        LadderFactory ladderFactory = new LadderFactory(new LineFactory(new RandomDirectionGenerator()));

        Users users = new Users(inputView.inputUserNames());
        Ladder ladder = ladderFactory.generateLadder(users.size(), new LadderHeight(inputView.inputLadderHeight()));

        resultView.printResult(users, ladder);
    }

}
