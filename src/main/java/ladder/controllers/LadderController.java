package ladder.controllers;

import ladder.domain.Ladder;
import ladder.domain.Names;
import ladder.views.InputView;
import ladder.views.OutputView;

public class LadderController {
    public static void run() {
        final Names names = new Names(InputView.names());
        final int ladderHeight = InputView.ladderHeight();
        final Ladder ladder = new Ladder(names.count(), ladderHeight);

        OutputView.printResultMessage();
        OutputView.print(names);
        OutputView.print(ladder);
    }
}
