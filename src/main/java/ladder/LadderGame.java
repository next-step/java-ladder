package ladder;

import ladder.domain.AutoLineGenerator;
import ladder.domain.Ladder;
import ladder.domain.Participants;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGame {
    public static void main(String[] args) {
        String[] participantsNames = InputView.inputParticipants();
        Participants participants = new Participants(participantsNames);

        int ladderHeight = InputView.inputLadderHeight();
        Ladder ladder = Ladder.create(participants.getCountOfParticipants(), ladderHeight, AutoLineGenerator.create());

        ResultView.printResult(participants.getPaticipants(), ladder.getFloors());
    }
}
