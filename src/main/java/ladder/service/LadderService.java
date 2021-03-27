package ladder.service;

import ladder.domain.ParticipantList;

import java.util.List;

public class LadderService {

    public List<String> verifiedParticipants(String participantString) {
        ParticipantList participantList = new ParticipantList(participantString);
        return participantList.dto();
    }
}
