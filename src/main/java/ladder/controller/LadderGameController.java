package ladder.controller;

import ladder.refactoring.domain.LadderGame;
import ladder.refactoring.domain.LadderResult;
import ladder.refactoring.domain.Participant;
import ladder.refactoring.domain.Rewards;
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
        Participant target = Participant.of(inputView.getTargetName());

        outputView.printGameResult(target, result, rewards);
    }
}
