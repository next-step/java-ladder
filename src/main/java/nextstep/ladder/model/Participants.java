package nextstep.ladder.model;

import java.util.List;

public final class Participants {
    private final List<Participant> participants;

    public Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public int ladderSize(){
        return participants.size();
    }
}
