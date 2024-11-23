package nextstep.ladder.controller;

import nextstep.ladder.domain.LadderFactory;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderController {
    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startLadder() {
        String names = inputView.inputName();
        int maxLadder = inputView.inputMaxLadder();

        Participants participants  = new Participants(names);

        Lines lines = LadderFactory.createLadder(participants, maxLadder);

        outputView.outputResult(participants, lines);
    }
}
