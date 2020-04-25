package ladder.controller;

import ladder.controller.response.LadderResult;
import ladder.domain.Ladder;
import ladder.domain.Persons;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {
    public static void ladderGameStart() {
        Persons persons = InputView.getPersons();
        int ladderHeight = InputView.getLadderHeight();

        Ladder ladder = Ladder.getInstanceWithHeight(ladderHeight, persons.getCount());

        ResultView.printLadderResult(LadderResult.generateLadderResult(persons, ladder));
    }
}
