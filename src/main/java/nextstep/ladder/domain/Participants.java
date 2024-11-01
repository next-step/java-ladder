package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;

public class Participants {

    private final List<Participant> participants;

    public Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public List<Participant> getParticipants() {
        return Collections.unmodifiableList(participants);
    }

    public int size() {
        return participants.size();
    }
}
