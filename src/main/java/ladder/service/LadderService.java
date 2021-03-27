package ladder.service;

import ladder.domain.Ladder;
import ladder.domain.ParticipantList;
import ladder.domain.ladderMap.LadderMap;

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

    public List<String> ladderMap(List<String> verifiedParticipants, int verifiedMaximumLadderHeight) {
        ParticipantList participantList = new ParticipantList(verifiedParticipants);
        Ladder ladder = new Ladder(verifiedMaximumLadderHeight);
        LadderMap ladderMap = new LadderMap(participantList, ladder);
        return ladderMap.dto();
    }
}
