package ladder;

import ladder.domain.Ladder;
import ladder.domain.Participants;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {
    public static void main(String[] args) {
        Participants participants = InputView.askParticipants();
        int ladderHeight = InputView.askLadderHeight();
        Ladder ladder = new Ladder(ladderHeight, participants.countOfPerson());
        ResultView.showParticipants(participants);
        ResultView.showLadder(ladder);
    }
}
