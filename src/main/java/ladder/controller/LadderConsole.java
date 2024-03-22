package ladder.controller;

import java.util.List;
import ladder.domain.Ladder;
import ladder.domain.LadderFactory;
import ladder.domain.Name;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderConsole {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderConsole(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        List<Name> names = inputView.inputPariticipantNames();
        outputView.printLine();
        int height = inputView.inputHeight();

        Ladder ladder = LadderFactory.generate(names.size(), height);
        outputView.printLadder(ladder, names);
    }
}
