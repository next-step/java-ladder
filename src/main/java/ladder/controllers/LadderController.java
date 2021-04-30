package ladder.controllers;

import ladder.domain.Ladder;
import ladder.domain.LadderResults;
import ladder.domain.Names;
import ladder.domain.Prizes;
import ladder.views.InputView;
import ladder.views.OutputView;

public class LadderController {
    public static void run() {
        final Names names = new Names(InputView.names());
        final Prizes prizes = new Prizes(InputView.prizes());
        final int ladderHeight = InputView.ladderHeight();
        final Ladder ladder = new Ladder(names.count(), ladderHeight);
        final LadderResults ladderResults = ladder.ladderResults(names, prizes);

        OutputView.printLadderResultMessage();
        OutputView.print(names);
        OutputView.print(ladder);
        OutputView.print(prizes);

        while (true) {
            OutputView.print(ladderResults, InputView.name());
        }
    }
}
