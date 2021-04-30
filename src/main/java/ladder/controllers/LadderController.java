package ladder.controllers;

import ladder.domain.Ladder;
import ladder.domain.LadderResults;
import ladder.domain.People;
import ladder.domain.Prizes;
import ladder.views.InputView;
import ladder.views.OutputView;

public class LadderController {
    public static void run() {
        final People people = new People(InputView.names());
        final Prizes prizes = new Prizes(InputView.prizes());
        final int ladderHeight = InputView.ladderHeight();
        final Ladder ladder = new Ladder(people.count(), ladderHeight);
        final LadderResults ladderResults = ladder.ladderResults(people, prizes);

        OutputView.printLadderResultMessage();
        OutputView.print(people);
        OutputView.print(ladder);
        OutputView.print(prizes);

        while (true) {
            OutputView.print(ladderResults, InputView.name());
        }
    }
}
