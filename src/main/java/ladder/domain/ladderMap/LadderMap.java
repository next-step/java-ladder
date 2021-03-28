package ladder.domain.ladderMap;

import ladder.domain.Height;
import ladder.domain.ParticipantList;

public class LadderMap {

    private ParticipantList participantList;
    private Plane plane;

    public LadderMap(ParticipantList participantList, Height ladder) {
        this.participantList = participantList;
        this.plane = new Plane(participantList, ladder);
    }

    public ParticipantList participantList() {
        return this.participantList;
    }

    public Plane plane(){
        return this.plane;
    }
}
