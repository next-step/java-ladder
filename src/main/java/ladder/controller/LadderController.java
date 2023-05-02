package ladder.controller;

import ladder.domain.Height;
import ladder.domain.LadderGame;
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
        LadderGame ladderGame = createLadderGame();
        ladderGame.drawAll(new RandomDrawStrategy());
        outputView.printLadder(ladderGame);
    }

    private LadderGame createLadderGame() {
        Users users = new Users(inputView.readNames());
        Height height = new Height(inputView.readHeight());
        return new LadderGame(users, height);
    }
}
