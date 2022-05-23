package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Participants;
import ladder.domain.RandomGenerateStrategy;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {

    private final InputView inputView;
    private final OutputView outputView;

    private LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public LadderController() {
        this(new InputView(), new OutputView());
    }

    public void startLadderGame() {
        Participants participants = inputView.inputParticipants();
        int maxLadderHeight = inputView.inputMaxLadderHeight();
        Ladder ladder = Ladder.createLadder(participants.size(), maxLadderHeight, new RandomGenerateStrategy());
        outputView.printResult(ladder, participants);
    }
}
