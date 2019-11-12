package ladder;

import ladder.model.Height;
import ladder.model.Participants;
import ladder.view.InputView;

public class Main {

    public static void main(String[] args) {
        Participants participants = InputView.getParticipants();
        Height height = InputView.getHeight();
    }

}
