package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.LadderResult;
import ladder.domain.Participants;
import ladder.domain.Results;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    public static void run() {
        Participants participants = Participants.from(InputView.inputParticipants());
        Results results = Results.of(participants.size(), InputView.inputResultData());
        Ladder ladder = Ladder.of(participants.size(), InputView.inputLadderHeight());

        ResultView.showLadder(participants, ladder, results);
        LadderResult result = ladder.getLadderResult(participants, results);
        ResultView.showResult(result.getSelectResult(InputView.inputParticipantResult()));
    }
}
