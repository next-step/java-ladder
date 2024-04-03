package ladder;

import ladder.domain.Participants;
import ladder.view.InputView;

public class LadderController {
    public static void main(String[] args) {
        Participants participants = InputView.askParticipants();
        int ladderHeight = InputView.askLadderHeight();
    }
}
