package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Main {

    public static void main(String[] args) {

        Participants participants = new Participants(InputView.askParticipantNames());
        LadderResults ladderResults = new LadderResults(InputView.askResults(), participants.size());
        Ladder ladder = new Ladder(participants.size(), InputView.askLadderHeights());

        ResultView.print(participants, ladder, ladderResults);
    }
}
