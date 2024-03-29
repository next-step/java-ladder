package nextstep.ladder.controller;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Names;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderController {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        final Names names = new Names(inputView.inputNames());
        final int height = inputView.inputLadderHeight();

        final Ladder ladder = new Ladder(names.getNumberOfNames(), height);

        outputView.printLadder(names, ladder);
    }
}
