package ladder.view;

import ladder.model.Height;
import ladder.model.Participants;

public class OutputView {

    public void printParticipants(Participants participants) {
        System.out.println(participants);
    }

    public void printLadderHeight(Height height) {
        System.out.println(height.getValue());
    }

}
