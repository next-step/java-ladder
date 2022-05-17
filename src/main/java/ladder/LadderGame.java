package ladder;

import ladder.domain.Participants;
import ladder.view.InputView;

public class LadderGame {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        Participants participants = inputView.readParticipants();
        participants.getParticipants().forEach(System.out::println);
    }
}
