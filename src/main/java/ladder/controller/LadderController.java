package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Participants;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    public static void main(String[] args) {
        String names = InputView.getParticipants();
        Participants participants = new Participants(names);

        int height = InputView.getHeightOfLadder();
        Ladder ladder = new Ladder(height, participants.countOfParticipants());

        ResultView.printResult(participants, ladder);
    }
}
