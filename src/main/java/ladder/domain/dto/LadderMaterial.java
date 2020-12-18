package ladder.domain.dto;

import ladder.domain.ladder.Ladder;

import java.util.List;

public class LadderMaterial {

    private final List<String> participantNames;
    private final Ladder ladder;

    public LadderMaterial(List<String> participantNames, Ladder ladder) {
        this.participantNames = participantNames;
        this.ladder = ladder;
    }

    public List<String> getParticipantNames() {
        return participantNames;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
