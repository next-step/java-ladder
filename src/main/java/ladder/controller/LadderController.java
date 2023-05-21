package ladder.controller;

import ladder.model.Ladder;
import ladder.model.Participants;
import ladder.view.input.InputView;
import ladder.view.result.ResultView;

public class LadderController {
    public static void ladderStart() {
        String[] names = InputView.inputParticipants();
        int height = InputView.inputLadderHeight();

        Participants participants = new Participants(names);
        Ladder ladder = Ladder.makeLadder(height, participants.count());

        ResultView.printLadder(participants, ladder);
    }
}
