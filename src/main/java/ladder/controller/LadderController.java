package ladder.controller;

import ladder.controller.response.LadderDto;
import ladder.domain.Ladder;
import ladder.domain.LadderResult;
import ladder.domain.Lines;
import ladder.domain.Persons;
import ladder.service.LadderService;
import ladder.service.type.GameResult;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    public static void ladderGameStart() {
        GameResult gameResult = ladderGameInit();


    }



    private static GameResult ladderGameInit() {
        Persons persons = InputView.getPersons();
        LadderResult ladderResult = InputView.getLadderResults(persons.getCount());
        int ladderHeight = InputView.getLadderHeight();

        Ladder ladder = Ladder.getInstance(
                Lines.getInstance(ladderHeight, ladderResult.getWidth()),
                ladderResult);

        ResultView.printLadderResult(LadderDto.getInstance(persons, ladder));

        return LadderService.getLadderGameResult(persons, ladder);
    }
}
