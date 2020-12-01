package ladder;

import ladder.domain.Line;
import ladder.domain.Participants;
import ladder.view.InputUi;
import ladder.view.OutputUi;

public class ladderApplication {
    public static void main(String[] args) {
        String ladderParticipants = InputUi.nameOfParticipate();
        Participants ladderMaker = Participants.of(ladderParticipants);

        int ladderMaximumHeight = InputUi.maximumHeight();
        OutputUi.printLadder(ladderMaker.getNames(), Line.of(ladderMaximumHeight));
    }
}
