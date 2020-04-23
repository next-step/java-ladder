package ladder.controller;

import ladder.controller.response.LadderResult;
import ladder.domain.Ladder;
import ladder.domain.Persons;
import ladder.view.ResultView;

public class LadderController {
    public static void ladderGameStart(Persons persons, int ladderHeight) {
        Ladder ladder = Ladder.getInstanceWithHeight(ladderHeight, persons.getCount());

        ResultView.printLadderResult(LadderResult.generateLadderResult(persons, ladder));
    }
}
