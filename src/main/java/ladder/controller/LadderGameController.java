package ladder.controller;

import ladder.domain.LadderGame;
import ladder.domain.LadderResult;
import ladder.domain.Name;
import ladder.domain.Rewards;
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
        String participantNames = inputView.getParticipantNames();
        Rewards rewards = Rewards.of(inputView.getRewards());
        String ladderHeight = inputView.getLadderHeight();

        LadderGame game = LadderGame.of(participantNames, ladderHeight);
        outputView.printLadderGame(game, rewards);

        LadderResult result = game.play();
        Name target = Name.of(inputView.getTargetName());

        outputView.printGameResult(target, result, rewards);
    }
}
