package ladder;

import ladder.domain.Lines;
import ladder.domain.Participants;
import ladder.view.InputUi;
import ladder.view.OutputUi;

public class ladderApplication {
    public static void main(String[] args) {
        String ladderParticipants = InputUi.nameOfParticipate();
        Participants ladderMaker = Participants.of(ladderParticipants);
        Lines lines = Lines.of(ladderMaker.getNames().size());

        int ladderMaximumHeight = InputUi.maximumHeight();
        OutputUi.printLadder(ladderMaker.getNames(), lines, ladderMaximumHeight);

        InputUi.close();
    }
}
