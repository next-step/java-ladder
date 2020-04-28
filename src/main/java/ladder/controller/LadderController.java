package ladder.controller;

import ladder.controller.response.LadderDto;
import ladder.domain.Ladder;
import ladder.domain.LadderResult;
import ladder.domain.Lines;
import ladder.domain.Persons;
import ladder.service.LadderService;
import ladder.service.type.GameResult;
import ladder.view.LadderInputView;
import ladder.view.LadderResultView;

public class LadderController {

    public static void ladderGameStart() {
        GameResult gameResult = ladderGameInit();


    }

    private static GameResult ladderGameInit() {
        Persons persons = LadderInputView.getPersons();
        LadderResult ladderResult = LadderInputView.getLadderResults(persons.getCount());
        int ladderHeight = LadderInputView.getLadderHeight();

        Ladder ladder = Ladder.getInstance(
                Lines.getInstance(ladderHeight, ladderResult.getWidth()),
                ladderResult);

        LadderResultView.printLadderResult(LadderDto.getInstance(persons, ladder));

        return LadderService.getLadderGameResult(persons, ladder);
    }
}
