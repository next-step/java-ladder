package ladder;

import ladder.domain.Ladder;
import ladder.domain.Participants;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderMain {
    public static void main(String[] args) {
        String participantsNames = InputView.inputParticipantsNames();
        int numberOfLadders = InputView.inputTheNumberOfLadders();
        Participants participants = Participants.from(participantsNames);

        ResultView.printResult(participants, Ladder.from(numberOfLadders, participants.count()));
    }
}
