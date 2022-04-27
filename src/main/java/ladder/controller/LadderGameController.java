package ladder.controller;

import ladder.model.Height;
import ladder.model.Participants;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameController {

    private final InputView inputView;

    private final OutputView outputView;

    public LadderGameController() {
        this(new InputView(), new OutputView());
    }

    public LadderGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        Participants participants = inputView.inputParticipants();
        Height height = inputView.inputLadderHeight();
        outputView.printParticipants(participants);
        outputView.printLadderHeight(height);
    }

}
