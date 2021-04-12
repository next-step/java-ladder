package ladder;

import ladder.domain.Ladder;
import ladder.domain.Participants;
import ladder.view.InputView;

public class LadderGame {

    private static final InputView INPUT_VIEW;

    static {
        INPUT_VIEW = new InputView();
    }

    public static void main(String[] args) {
        Participants participants = Participants.of(INPUT_VIEW.inputParticipantsByClient());
        int height = INPUT_VIEW.inputLadderHeightByClient();
        Ladder ladder = Ladder.from(participants, height);
    }
}
