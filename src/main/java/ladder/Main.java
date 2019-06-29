package ladder;

import ladder.domain.Ladder;
import ladder.domain.Participants;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Main {

    public static void main(String[] args) {

        Participants participants = new Participants(InputView.askParticipantNames());
        Ladder ladder = new Ladder(participants.size(), InputView.askLadderHeights());

        ResultView.printResult(participants, ladder);
    }
}
