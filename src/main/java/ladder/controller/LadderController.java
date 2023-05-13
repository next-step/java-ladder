package ladder.controller;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.RandomDrawStrategy;
import ladder.domain.Users;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {
    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startGame() {
        Ladder ladder = createLadder();
        outputView.printLadder(ladder);
    }

    private Ladder createLadder() {
        Users users = new Users(inputView.readNames());
        Height height = new Height(inputView.readHeight());
        return Ladder.of(users, height, new RandomDrawStrategy());
    }
}
