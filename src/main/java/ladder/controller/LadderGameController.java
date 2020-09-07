package ladder.controller;

import ladder.domain.LadderGame;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameController implements GameController {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public static LadderGameController of() {
        return new LadderGameController(
                InputView.getInstance(),
                OutputView.getInstance()
        );
    }

    @Override
    public void startGame() {
        LadderGame game = LadderGame.of(
                inputView.getParticipantNames(),
                inputView.getLadderHeight()
        );

        outputView.printLadderGame(game);
    }
}
