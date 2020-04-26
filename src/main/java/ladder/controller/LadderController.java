package ladder.controller;

import ladder.controller.response.LadderDto;
import ladder.domain.Ladder;
import ladder.domain.LadderResult;
import ladder.domain.Persons;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {
    public static void ladderGameStart() {
        Persons persons = InputView.getPersons();
        LadderResult ladderResult = InputView.getLadderResults(persons.getCount());
        int ladderHeight = InputView.getLadderHeight();

        Ladder ladder = Ladder.getInstance(ladderHeight, ladderResult);

        ResultView.printLadderResult(LadderDto.getInstance(persons, ladder));
    }
}
