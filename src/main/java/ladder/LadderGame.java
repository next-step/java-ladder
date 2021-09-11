package ladder;

import ladder.domain.AutoLineGenerator;
import ladder.domain.Ladder;
import ladder.domain.LadderSize;
import ladder.domain.Participants;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGame {
    public static void main(String[] args) {
        String[] participantsNames = InputView.inputParticipants();
        int ladderHeight = InputView.inputLadderHeight();

        LadderSize ladderSize = new LadderSize(participantsNames.length, ladderHeight);
        Participants participants = new Participants(participantsNames, ladderSize);
        Ladder ladder = Ladder.create(ladderSize, AutoLineGenerator.create());

        ResultView.printResult(participants.getPaticipants(), ladder.getFloors());
    }
}
