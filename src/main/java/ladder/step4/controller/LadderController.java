package ladder.step4.controller;

import ladder.step4.domain.*;
import ladder.step4.domain.strategy.*;
import ladder.step4.view.*;

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
            LadderDirectionStrategy.getInstance()
        );

        RESULT_VIEW.viewLadder(ladder, participants, ladderResults);

        LadderGame ladderGame = LadderGame.of(
            LadderGameExecutor.execute(participants, ladderResults, ladder)
        );

        String target;
        do {
            target = INPUT_VIEW.inputResultTarget();
            RESULT_VIEW.viewResult(ladderGame, participants, target);
        } while(!target.equals("all"));

    }
}
