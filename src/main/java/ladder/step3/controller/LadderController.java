package ladder.step3.controller;

import ladder.step3.domain.*;
import ladder.step3.domain.strategy.*;
import ladder.step3.view.*;

public class LadderController {
    private static final InputView INPUT_VIEW = InputView.getInstance();
    private static final ResultView RESULT_VIEW = ResultView.getInstance();

    public static void main(String[] args) {
        Participants participants = INPUT_VIEW.inputParticipants();
        LadderResults ladderResults = LadderResults.of(INPUT_VIEW.inputResults(), participants);
        LadderHeight ladderHeight = INPUT_VIEW.inputHeight();

        Ladder ladder = Ladder.of(
            participants,
            ladderHeight,
            LadderLineStrategyImpl.getInstance()
        );

        LadderGame ladderGame = LadderGame.of(
            LadderGameExecutor.execute(participants, ladderResults, ladder)
        );

        RESULT_VIEW.viewLadder(ladder, participants, ladderResults);
        String target;
        do {
            target = INPUT_VIEW.inputResultTarget();
            RESULT_VIEW.viewResult(ladderGame, participants, target);
        } while(!target.equals("all"));

    }
}
