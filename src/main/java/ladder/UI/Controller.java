package ladder.UI;

import ladder.domain.ladder.LadderContext;
import ladder.domain.user.Participants;

public class Controller {

    public static ResponseDto runLadderGame(String participantNames, int ladderHeight) {
        Participants participants = new Participants(participantNames);
        LadderContext ladderContext = new LadderContext((ladderHeight), participants.size());

        return new ResponseDto(participants, ladderContext);
    }
}
