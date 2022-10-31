package ladder;

import ladder.domain.Participant;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderMain {

    public static void main(String[] args) {
        final List<Participant> participants = InputView.inputParticipants();
        final int ladderHeight = InputView.inputLadderHeight();
        ResultView.print();
    }
}
