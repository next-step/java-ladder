package ladder.service;

import ladder.domain.Ladder;
import ladder.domain.ParticipantList;

import java.util.List;

public class LadderService {

    public List<String> verifiedParticipants(String participantString) {
        ParticipantList participantList = new ParticipantList(participantString);
        return participantList.dto();
    }

    public int verifiedMaximumLadderHeight(int maximumLadderHeight) {
        Ladder ladder = new Ladder(maximumLadderHeight);
        return ladder.height();
    }
}
