package nextstep.ladder.controller;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.List;

public class LadderController {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<String> names = inputView.askNames();
        int height = inputView.askLadderHeight();

        Ladder ladder = Ladder.from(height, names.size());

        outputView.print(names, ladder);
    }
}
