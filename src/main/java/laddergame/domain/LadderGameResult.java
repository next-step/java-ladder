package laddergame.domain;

import java.util.List;

public class LadderGameResult {

    private final List<ParticipantName> participantNames;
    private final Ladder ladder;

    public LadderGameResult(List<ParticipantName> participantNames, Ladder ladder) {
        this.participantNames = participantNames;
        this.ladder = ladder;
    }

    public List<ParticipantName> getParticipantNames() {
        return participantNames;
    }

    public Ladder getLadder() {
        return ladder;
    }

}
