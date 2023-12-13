package ladder.controller;

import ladder.domain.Lines;
import ladder.domain.Participants;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    public static void run() {
        Participants participants = Participants.from(InputView.inputParticipants());
        int ladderHeight = InputView.inputLadderHeight();
        Lines lines = new Lines(participants.size(), ladderHeight);
        ResultView.showResult(participants, lines);
    }
}
