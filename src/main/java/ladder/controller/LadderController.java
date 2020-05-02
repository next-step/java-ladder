package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Rewards;
import ladder.domain.Persons;
import ladder.service.LadderService;
import ladder.service.type.GameResult;
import ladder.view.GameInputView;
import ladder.view.GameResultView;
import ladder.view.LadderInputView;
import ladder.view.LadderResultView;

public class LadderController {
    public static final String END_GAME_COMMENT = "끝";

    public static void ladderGameStart() {
        GameResult gameResult = ladderGameInit();

        while (printResultIfValidInput(gameResult)) ;
    }

    private static boolean printResultIfValidInput(GameResult gameResult) {
        String getResultKey = GameInputView.getPersonToGetResult();
        if (END_GAME_COMMENT.equals(getResultKey)) {
            return false;
        }

        GameResultView.printGameResult(
                LadderService.getRequestedResult(gameResult, getResultKey)
        );

        return true;
    }

    private static GameResult ladderGameInit() {
        Persons persons = LadderInputView.getPersons();
        Rewards rewards = LadderInputView.getLadderResults(persons.getCount());
        int ladderHeight = LadderInputView.getLadderHeight();

        Ladder ladder = Ladder.getInstance(ladderHeight, rewards.getWidth());

        LadderResultView.printLadderResult(persons, ladder, rewards);

        return LadderService.getLadderGameResult(persons, ladder);
    }
}
