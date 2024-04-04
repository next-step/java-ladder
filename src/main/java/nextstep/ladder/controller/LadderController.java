package nextstep.ladder.controller;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.domain.LadderResultDeterminer;
import nextstep.ladder.domain.Names;
import nextstep.ladder.domain.LadderResultManager;
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
        final LadderResult ladderResult = new LadderResult(inputView.inputResult());
        final Ladder ladder = new Ladder(names.getNumberOfNames(), inputView.inputLadderHeight());

        outputView.printLadder(names, ladder);

        final LadderResultDeterminer determiner = new LadderResultDeterminer(ladderResult, names);
        final LadderResultManager ladderResultManager = new LadderResultManager(names, ladder, determiner);

        outputView.printResult(inputView.inputName(), ladderResultManager);
    }
}
