package ladder;

import ladder.domain.Participants;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderApplication {
    public static void main(String[] args) {
        Participants participants = InputView.inputParticipants();
        int maxHeight = InputView.inputMaxLadderHeight();
        ResultView.printResult();
    }
}
