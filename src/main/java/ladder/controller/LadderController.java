package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.LadderResult;
import ladder.domain.Participants;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    public static void run() {
        Participants participants = Participants.from(InputView.inputParticipants());
        Ladder ladder = Ladder.of(participants.size(), InputView.inputResultData(), InputView.inputLadderHeight());
        ResultView.showLadder(participants, ladder);
        LadderResult result = ladder.getLadderResult(participants);
        ResultView.showResult(result.getSelectResult(InputView.inputParticipantResult()));
    }
}
