package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.LadderGenerator;
import ladder.domain.Participants;
import ladder.domain.RandomDirectionGenerateStrategy;
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
        LadderGenerator ladderGenerator = new LadderGenerator(new RandomDirectionGenerateStrategy());
        Ladder ladder = ladderGenerator.createLadder(participants, maxLadderHeight);
        outputView.printResult(ladder);
    }
}
