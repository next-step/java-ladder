package nextstep.ladder.domain;

import java.util.List;

public class LadderGame {

    private List<Participant> participants;
    private Ladder ladder;

    public LadderGame(List<Participant> participants) {
        
    }
    public LadderGame(List<Participant> participants, Ladder ladder) {
        this.participants = participants;
        this.ladder = ladder;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public Ladder getLadder() {
        return ladder;
    }

}
