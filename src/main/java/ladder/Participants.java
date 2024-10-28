package ladder;

import java.util.Collections;
import java.util.List;

public class Participants {

    private final List<Participant> participants;

    public Participants(String participant) {
        this.participants = Participant.splitParticipant(participant);
    }

    public List<Participant> getParticipants() {
        return Collections.unmodifiableList(participants);
    }

}