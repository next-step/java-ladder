package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderHeight;
import ladder.domain.Participants;
import ladder.strategy.BridgeLinesRandomStrategy;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderMain {

    public static void main(String[] args) {
        final Participants participants = InputView.inputParticipants();
        final LadderHeight ladderHeight = InputView.inputLadderHeight();
        ResultView.print(new Ladder(participants, ladderHeight, new BridgeLinesRandomStrategy()));
    }
}
