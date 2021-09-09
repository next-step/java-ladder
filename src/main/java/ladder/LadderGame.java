package ladder;

import ladder.domain.Ladder;
import ladder.domain.Participants;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGame {
    public static void main(String[] args) {
        Participants participants = InputView.inputParticipants();
        Ladder ladder = InputView.inputLadder(participants.getCountOfParticipants());

        ResultView.printResult(participants.getPaticipants(), ladder.getFloors());
    }
}
