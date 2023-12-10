package ladder.controller;

import ladder.domain.Lines;
import ladder.domain.Participants;
import ladder.service.LadderService;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    public static void run() {
        Participants participants = LadderService.createParticipants(InputView.inputParticipants());
        int ladderHeight = InputView.inputLadderHeight();

        Lines lines = LadderService.createLines(participants.size(), ladderHeight);
        ResultView.showResult(participants, lines);
    }
}
