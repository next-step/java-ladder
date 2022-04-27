package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Participants {

    private final List<Participant> participants;

    public Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public int size() {
        return participants.size();
    }

    public List<Participant> getParticipants() {
        return new ArrayList<>(participants);
    }
}
