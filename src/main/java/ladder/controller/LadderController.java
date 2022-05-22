package ladder.controller;

import ladder.domain.Participants;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startLadderGame() {
        Participants participants = inputView.inputParticipants();
        int maxLadderHeight = inputView.inputMaxLadderHeight();

    }
}
